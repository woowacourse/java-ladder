package laddergame.controller;

import laddergame.domain.ladder.ConnectionStrategy;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGame;
import laddergame.domain.player.Name;
import laddergame.domain.player.Names;
import laddergame.domain.player.Players;
import laddergame.domain.prize.Prizes;
import laddergame.domain.prize.Result;
import laddergame.domain.prize.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class GameController {

    private final ConnectionStrategy connectionStrategy;

    public GameController(final ConnectionStrategy connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
    }

    public void process() {
        final Names names = readNamesWithRetry();
        final Prizes prizes = readResultWithRetry(names.getSize());
        final Ladder ladder = readHeightWithRetry(names, connectionStrategy);

        OutputView.printPlayerAll(names);
        OutputView.printLadder(names, ladder);
        OutputView.printPrizesAll(prizes);

        final LadderGame ladderGame = new LadderGame(ladder, new Players(names), prizes);
        ladderGame.startGame();
        final Results results = ladderGame.createResults();

        while (true) {
            final Name resultName = readResultPlayerNameWithRetry();
            final List<Result> result = results.findResults(resultName);
            OutputView.printResult(result);
        }

    }

    private Names readNamesWithRetry() {
        try {
            return new Names(InputView.readNames());
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readNamesWithRetry();
        }
    }

    private Ladder readHeightWithRetry(final Names names, final ConnectionStrategy connectionStrategy) {
        try {
            return new Ladder(InputView.readHeight(), names.getSize(), connectionStrategy);
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readHeightWithRetry(names, connectionStrategy);
        }
    }

    private Prizes readResultWithRetry(final int size) {
        try {
            return new Prizes(InputView.readResults(), size);
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readResultWithRetry(size);
        }
    }

    private Name readResultPlayerNameWithRetry() {
        try {
            return new Name(InputView.readResultPlayerName());
        } catch (IllegalStateException e) {
            OutputView.printMessage(e.getMessage());
            return readResultPlayerNameWithRetry();
        }
    }
}
