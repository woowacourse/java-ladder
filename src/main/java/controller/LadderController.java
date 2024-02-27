package controller;

import domain.Height;
import domain.LadderGame;
import domain.Players;
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
        Height height = heightInput(MAX_TRYCOUNT);
        LadderGame ladderGame = new LadderGame(players, height);
        OutputView.printResult(ladderGame.getResult());
    }

    private Players nameInput(int tryCount) {
        if (tryCount == 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            return new Players(InputView.readNames(consoleReader));
        } catch (IllegalArgumentException e) {
            return nameInput(tryCount - 1);
        }
    }

    private Height heightInput(int tryCount) {
        if (tryCount == 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            return InputView.readHeight(consoleReader);
        } catch (IllegalArgumentException e) {
            return heightInput(tryCount - 1);
        }
    }
}
