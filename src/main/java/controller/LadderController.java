package controller;

import domain.Height;
import domain.LadderGame;
import domain.Players;
import domain.Winnings;
import util.ConsoleReader;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final int MAX_TRYCOUNT = 5;
    private final ConsoleReader consoleReader;

    public LadderController() {
        this.consoleReader = new ConsoleReader();
    }

    public void run() {
        Players players = nameInput(MAX_TRYCOUNT);
        Winnings winnings = winningsInput(MAX_TRYCOUNT, players.getPersonCount());
        Height height = heightInput(MAX_TRYCOUNT);
        LadderGame ladderGame = new LadderGame(players, winnings, height);
        OutputView.printResult(ladderGame.getResult());
    }

    private Players nameInput(int tryCount) {
        if (tryCount == 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            return new Players(InputView.readNames(consoleReader));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return nameInput(tryCount - 1);
        }
    }

    private Winnings winningsInput(int tryCount, int personCount) {
        if (tryCount == 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            return new Winnings(InputView.readWinnings(consoleReader), personCount);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return winningsInput(tryCount - 1, personCount);
        }
    }

    private Height heightInput(int tryCount) {
        if (tryCount == 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            return InputView.readHeight(consoleReader);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return heightInput(tryCount - 1);
        }
    }
}
