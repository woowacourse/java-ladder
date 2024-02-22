package controller;

import domain.Height;
import domain.LadderGame;
import domain.Players;
import util.ConsoleReader;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final ConsoleReader consoleReader;

    public LadderController() {
        this.consoleReader = new ConsoleReader();
    }

    public void run() {
        Players players = nameInput();
        Height height = heigthInput();
        LadderGame ladderGame = new LadderGame(players, height);
        OutputView.printResult(ladderGame.getResult());
    }

    private Players nameInput() {
        Players names = null;
        for (int tryCount = 0; tryCount < 5 && names == null; tryCount++) {
            names = getName();
        }
        if (names == null) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        return names;
    }

    private Players getName() {
        try {
            return new Players(InputView.readNames(consoleReader));
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private Height heigthInput() {
        Height height = null;
        for (int tryCount = 0; tryCount < 5 && height == null; tryCount++) {
            height = getHeight();
        }
        if (height == null) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        return height;
    }

    private Height getHeight() {
        try {
            return InputView.readHeight(consoleReader);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
