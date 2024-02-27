package controller;

import domain.Height;
import domain.LadderGame;
import domain.Players;
import domain.Winnings;
import util.ConsoleReader;
import view.InputView;
import view.OutputView;

public class LadderController {

    private final ConsoleReader consoleReader;
    private static final int MAX_DEPTH = 5;

    public LadderController() {
        this.consoleReader = new ConsoleReader();
    }

    public void run() {
        Players players = nameInput(MAX_DEPTH);
        Height height = heightInput(MAX_DEPTH);
        Winnings winnings = winningsInput(MAX_DEPTH);
        LadderGame ladderGame = new LadderGame(players, height, winnings);
        OutputView.printResult(ladderGame.getLadderShape());
    }

    private Players nameInput(int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            return new Players(InputView.readNames(consoleReader));
        } catch (IllegalArgumentException e) {
            return nameInput(depth - 1);
        }
    }

    private Height heightInput(int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            return InputView.readHeight(consoleReader);
        } catch (IllegalArgumentException e) {
            return heightInput(depth - 1);
        }
    }

    private Winnings winningsInput(int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            return new Winnings(InputView.readWinnings(consoleReader));
        } catch (IllegalArgumentException e) {
            return winningsInput(depth - 1);
        }
    }
}
