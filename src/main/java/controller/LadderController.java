package controller;

import domain.LadderGame;
import util.ConsoleReader;
import view.InputView;
import view.OutputView;

import java.util.List;

public class LadderController {

    private final ConsoleReader consoleReader;

    public LadderController() {
        this.consoleReader = new ConsoleReader();
    }

    public void run() {
        List<String> names = nameInput();
        int height = heigthInput();
        LadderGame ladderGame = new LadderGame(names, height);
        OutputView.printResult(ladderGame.getResult());
    }

    private List<String> nameInput() {
        List<String> names = null;
        for (int tryCount = 0; tryCount < 5 && names == null; tryCount++) {
            names = getName();
        }
        if (names == null) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        return names;
    }

    private List<String> getName() {
        try {
            return InputView.readNames(consoleReader);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    private int heigthInput() {
        Integer height = null;
        for (int tryCount = 0; tryCount < 5 && height == null; tryCount++) {
            height = getHeight();
        }
        if (height == null) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        return height;
    }

    private Integer getHeight() {
        try {
            return InputView.readHeight(consoleReader);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
