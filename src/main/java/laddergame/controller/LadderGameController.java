package laddergame.controller;

import laddergame.domain.*;
import laddergame.util.RandomBooleanGenerator;
import laddergame.util.RepeatValidator;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class LadderGameController {

    public void run() {
        final Players players = initPlayers();
        final Prizes prizes = initPrizes(players.size());
        final int ladderHeight = initLadderHeight();
        final Ladder ladder = new Ladder(players.size(), ladderHeight, new RandomBooleanGenerator());
        printLadderGame(players, ladder, prizes);

        final Result result = new Result(players, ladder, prizes);
        printLadderGameResult(result);
    }

    private Players initPlayers() {
        return RepeatValidator.retryUntilValidate(() -> {
            OutputView.printPlayerNamesRequestMsg();
            List<String> playerNames = InputView.inputPlayerNames();
            return new Players(playerNames);
        });
    }

    private Prizes initPrizes(int playersCount) {
        return RepeatValidator.retryUntilValidate(() -> {
            OutputView.printPrizesRequestMsg();
            List<String> prizeNames = InputView.inputLadderPrizes();
            return new Prizes(prizeNames, playersCount);
        });
    }

    private int initLadderHeight() {
        return RepeatValidator.retryUntilValidate(() -> {
            OutputView.printLadderHeightRequestMsg();
            return InputView.inputLadderHeight();
        });
    }

    private void printLadderGame(Players players, Ladder ladder, Prizes prizes) {
        OutputView.printLadderResultMsg();
        OutputView.printPlayerNames(players.getPlayerNames());
        OutputView.printLadderMap(ladder.getLadder());
        OutputView.printPrizeNames(prizes.getPrizes());
    }

    private Result printLadderGameResult(Result result) {
        return RepeatValidator.retryUntilValidate(() -> {
            repeatPrintPlayerResult(result);
            OutputView.printLadderGameAllResult(result.getAllResults());
            return result;
        });
    }

    private void repeatPrintPlayerResult(Result result) {
        String playerName = readPlayerNameForResult();
        while (!playerName.equals("all")) {
            OutputView.printLadderGameResult(result.getResult(playerName));
            playerName = readPlayerNameForResult();
        }
    }

    private String readPlayerNameForResult() {
        return RepeatValidator.retryUntilValidate(() -> {
            OutputView.printPlayerNameForResult();
            return InputView.inputPlayerNameForResult();
        });
    }
}
