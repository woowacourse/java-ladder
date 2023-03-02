package controller;

import domain.game.LadderGame;
import domain.ladder.Ladder;
import domain.ladder.LadderGenerator;
import domain.player.Names;
import domain.player.Players;
import domain.result.Prizes;
import domain.result.Result;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;
import view.constant.Command;

public class LadderGameController {

    private final Names names;
    private final Prizes prizes;
    private final Ladder ladder;

    public LadderGameController() {
        this.names = getNames();
        this.prizes = getPrizes();
        this.ladder = buildLadder();
    }

    public void start() {
        printLadderResult();
        final Result result = playGame();
        printGameResult(result);
    }

    private void printGameResult(Result result) {
        try {
            printGameResultUntilEnd(result);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            printGameResult(result);
        }

    }

    private Result playGame() {
        Players players = new Players(names);
        LadderGame game = new LadderGame(ladder, players, prizes);
        game.play();

        return game.getResult();
    }

    private Ladder buildLadder() {
        try {
            int height = getHeight();
            return new LadderGenerator(new RandomBooleanGenerator()).build(height, names.count());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return buildLadder();
        }
    }

    private void printLadderResult() {
        OutputView.printResult(names, ladder, prizes);
    }

    private void printGameResultUntilEnd(final Result result) {
        String query = getResultQuery();
        while (!query.equals(Command.END.getCommand())) {
            printGameResultByQuery(result, query);
            query = getResultQuery();
        }
    }

    private void printGameResultByQuery(final Result result, final String query) {
        if (query.equals(Command.ALL.getCommand())) {
            OutputView.printPlayerResult(result.toString());
            return;
        }
        OutputView.printPlayerResult(result.queryByPlayer(query));
    }

    private String getResultQuery() {
        try {
            return InputView.getPlayerResult();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getResultQuery();
        }
    }

    private Names getNames() {
        try {
            return new Names(InputView.getNames());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getNames();
        }
    }

    private int getHeight() {
        try {
            return InputView.getHeight();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getHeight();
        }
    }

    private Prizes getPrizes() {
        try {
            return new Prizes(InputView.getPrizes(this.names.getNames().size()));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return getPrizes();
        }
    }
}
