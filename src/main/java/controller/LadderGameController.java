package controller;

import domain.Height;
import domain.Ladder;
import domain.Players;
import domain.booleangenerator.BooleanGenerator;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator booleanGenerator;

    public LadderGameController(InputView inputView, OutputView outputView, BooleanGenerator booleanGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.booleanGenerator = booleanGenerator;
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
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return repeatUntilValidInput(supplier);
        }
    }

    private Ladder initLadder(int playerCount, Height height) {
        return new Ladder(playerCount, height, booleanGenerator);
    }
}
