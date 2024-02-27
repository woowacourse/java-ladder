package controller;

import domain.*;
import util.ConsoleReader;
import view.InputView;
import view.OutputView;

import java.util.Objects;

public class LadderController {

    private final ConsoleReader consoleReader;
    private static final int MAX_DEPTH = 5;

    public LadderController() {
        this.consoleReader = new ConsoleReader();
    }

    public void run() {
        Players players = nameInput(MAX_DEPTH);
        Winnings winnings = winningsInput(MAX_DEPTH, players);
        Height height = heightInput(MAX_DEPTH);
        LadderGame ladderGame = new LadderGame(players, height, winnings);
        OutputView.printLadder(ladderGame.getLadderShape());
        Result result = new Result(ladderGame.getResult());
        ResultName resultName = resultNameInput(MAX_DEPTH, players);
        findResult(result, resultName, players);
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

    private Winnings winningsInput(int depth, Players players) {
        if (depth <= 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            Winnings winnings = new Winnings(InputView.readWinnings(consoleReader));
            winnings.isSameNumberWithPlayers(players);
            return winnings;
        } catch (IllegalArgumentException e) {
            return winningsInput(depth - 1, players);
        }
    }

    private ResultName resultNameInput(int depth, Players players) {
        if (depth <= 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
        try {
            return new ResultName(InputView.readResultName(consoleReader), players);
        } catch (IllegalArgumentException e) {
            return resultNameInput(depth - 1, players);
        }
    }

    private void findResult(Result result, ResultName resultName, Players players) {
        while (!Objects.equals(resultName.getName(), "all")) {
            OutputView.printResultByPerson(result.getResultByPerson(resultName));
            resultName = resultNameInput(MAX_DEPTH, players);
        }
        OutputView.printResultByAll(result.getResultByAll());
    }
}
