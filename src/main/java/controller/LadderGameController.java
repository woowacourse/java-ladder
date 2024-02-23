package controller;

import domain.Height;
import domain.Ladder;
import domain.Players;
import domain.booleangenerator.BooleanGenerator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private static final int MAXIMUM_REPEAT_COUNT = 3;

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;
    private int repeatCount;
    private final Map<Integer, Boolean> linesInformation;

    public LadderGameController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
        repeatCount = 0;
        linesInformation = new LinkedHashMap<>();
    }

    public void run() {
        Players players = initPlayers();
        Height height = initHeight();
        Ladder ladder = initLadder(players.getSize(), height);

        outputView.printResult(ladder.getLinesInformation(), players.getNames());
    }

    private Players initPlayers() {
        return repeatUntilValidInput(() -> new Players(inputView.readPlayerNames()));
    }

    private Height initHeight() {
        return repeatUntilValidInput(() -> new Height(inputView.readHeight()));
    }

    private <R> R repeatUntilValidInput(Supplier<R> supplier) {
        CheckStackOverFlowError();
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            repeatCount++;
            outputView.printErrorMessage(e.getMessage());
            return repeatUntilValidInput(supplier);
        }
    }

    private void CheckStackOverFlowError() {
        if (repeatCount > MAXIMUM_REPEAT_COUNT) {
            outputView.printErrorMessage("재시도 횟수 초과 입니다. 프로그램을 다시 실행해주세요.");
            throw new IllegalArgumentException();
        }
    }

    private Ladder initLadder(int playerCount, Height height) {
        return new Ladder(playerCount, height, booleanGenerator);
    }
}
