package controller;

import domain.Height;
import domain.LadderGame;
import domain.Players;
import domain.Result;
import domain.ResultName;
import domain.Winnings;
import java.util.Objects;
import util.ConsoleReader;
import view.InputView;
import view.OutputView;

public class LadderController {

    private static final int MAX_DEPTH = 5;

    private final ConsoleReader consoleReader;

    public LadderController() {
        this.consoleReader = new ConsoleReader();
    }

    public void run() {
        Players players = getNameInput(MAX_DEPTH);
        Winnings winnings = getWinningsInput(MAX_DEPTH, players);
        Height height = getHeightInput(MAX_DEPTH);
        LadderGame ladderGame = new LadderGame(players, height, winnings);
        OutputView.printLadder(ladderGame.getLadderShape());
        Result result = new Result(ladderGame.getResult());
        ResultName resultName = getResultNameInput(MAX_DEPTH, players);
        findResult(result, resultName, players);
    }

    private Players getNameInput(int depth) {
        checkRetry(depth);
        try {
            return new Players(InputView.readNames(consoleReader));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getNameInput(depth - 1);
        }
    }

    private Height getHeightInput(int depth) {
        checkRetry(depth);
        try {
            return InputView.readHeight(consoleReader);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getHeightInput(depth - 1);
        }
    }

    private Winnings getWinningsInput(int depth, Players players) {
        checkRetry(depth);
        try {
            return getWinnings(players);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getWinningsInput(depth - 1, players);
        }
    }

    private Winnings getWinnings(Players players) {
        Winnings winnings = new Winnings(InputView.readWinnings(consoleReader));
        winnings.isSameNumberWithPlayers(players);
        return winnings;
    }

    private ResultName getResultNameInput(int depth, Players players) {
        checkRetry(depth);
        try {
            return new ResultName(InputView.readResultName(consoleReader), players);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getResultNameInput(depth - 1, players);
        }
    }

    private void findResult(Result result, ResultName resultName, Players players) {
        while (!Objects.equals(resultName.getName().getName(), "all")) {
            OutputView.printResultByPerson(result.getResultByPerson(resultName.getName()));
            resultName = getResultNameInput(MAX_DEPTH, players);
        }
        OutputView.printResultByAll(result.getResultByAll());
    }

    private void checkRetry(int depth) {
        if (depth <= 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다.");
        }
    }
}
