package controller;

import domain.Height;
import domain.LadderGame;
import domain.LadderResult;
import domain.Players;
import domain.Winnings;
import util.ConsoleReader;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final int MAX_TRY_COUNT = 5;
    private final ConsoleReader consoleReader;

    public LadderController() {
        this.consoleReader = new ConsoleReader();
    }

    public void run() {
        Players players = nameInput(MAX_TRY_COUNT);
        Winnings winnings = winningsInput(MAX_TRY_COUNT, players.getPersonCount());
        Height height = heightInput(MAX_TRY_COUNT);
        LadderGame ladderGame = new LadderGame(players, winnings, height);
        OutputView.printLadder(ladderGame.getLadderSequence());

        LadderResult ladderResult = new LadderResult(ladderGame.getResult());
        resultPhase(ladderResult, MAX_TRY_COUNT);
    }

    private void resultPhase(LadderResult ladderResult, int tryCount) {
        validateTryCount(tryCount);
        try {
            String resultPlayer = InputView.readResultPlayer(consoleReader);
            OutputView.printResult(
                    ladderResult.getWinning(resultPlayer));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            resultPhase(ladderResult, tryCount - 1);
        }
    }

    private Players nameInput(int tryCount) {
        validateTryCount(tryCount);
        try {
            return new Players(InputView.readNames(consoleReader));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return nameInput(tryCount - 1);
        }
    }

    private Winnings winningsInput(int tryCount, int personCount) {
        validateTryCount(tryCount);
        try {
            return new Winnings(InputView.readWinnings(consoleReader), personCount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return winningsInput(tryCount - 1, personCount);
        }
    }

    private Height heightInput(int tryCount) {
        validateTryCount(tryCount);
        try {
            return InputView.readHeight(consoleReader);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return heightInput(tryCount - 1);
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount == 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다");
        }
    }
}
