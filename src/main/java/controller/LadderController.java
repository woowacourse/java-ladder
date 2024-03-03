package controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.LadderResult;
import domain.Line;
import domain.PlayerNames;
import domain.WinningNames;
import java.util.ArrayList;
import java.util.List;
import util.ConsoleReader;
import util.RandomGenerator;
import view.InputView;
import view.OutputView;

public class LadderController {
    private static final int MAX_TRY_COUNT = 5;
    private final ConsoleReader consoleReader;

    public LadderController() {
        this.consoleReader = new ConsoleReader();
    }

    public void run() {
        PlayerNames playerNames = nameInput(MAX_TRY_COUNT);
        WinningNames winningNames = winningsInput(MAX_TRY_COUNT, playerNames.getPersonCount());
        Height height = heightInput(MAX_TRY_COUNT);
        List<Line> lines = makeLines(playerNames.getPersonCount(), height);
        LadderGame ladderGame = new LadderGame(playerNames, winningNames, new Ladder(lines));
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

    private PlayerNames nameInput(int tryCount) {
        validateTryCount(tryCount);
        try {
            return new PlayerNames(InputView.readNames(consoleReader));
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return nameInput(tryCount - 1);
        }
    }

    private WinningNames winningsInput(int tryCount, int personCount) {
        validateTryCount(tryCount);
        try {
            return new WinningNames(InputView.readWinnings(consoleReader), personCount);
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

    private List<Line> makeLines(int personCount, Height height) {
        List<Line> lines = new ArrayList<>();
        RandomGenerator randomGenerator = new RandomGenerator();
        for (int i = 0; i < height.getHeight(); ++i) {
            lines.add(new Line(randomGenerator.generate(personCount)));
        }
        return lines;
    }

    private void validateTryCount(int tryCount) {
        if (tryCount == 0) {
            throw new IllegalArgumentException("입력 허용횟수 5회를 초과했습니다");
        }
    }
}
