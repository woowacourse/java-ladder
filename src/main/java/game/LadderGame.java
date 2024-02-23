package game;

import domain.LadderRowPattern;
import domain.Ladder;
import domain.LadderHeight;
import domain.Players;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanSupplier supplier;

    public LadderGame(InputView inputView, OutputView outputView, BooleanSupplier supplier) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.supplier = supplier;
    }

    public void play() {
        Players players = retryOnException(this::getNames);
        LadderHeight height = retryOnException(this::getHeight);

        Ladder ladder = Ladder.of(players, height);
        ladder.drawLines(supplier);
        List<LadderRowPattern> statuses = ladder.createStatuses();

        printLadderResult(players.getNames(), statuses);
    }

    private Players getNames() {
        outputView.printReadNames();
        List<String> names = inputView.readNames();
        return new Players(names);
    }

    private LadderHeight getHeight() {
        outputView.printReadLadderHeight();
        int height = inputView.readLadderHeight();
        return new LadderHeight(height);
    }

    private void printLadderResult(List<String> names, List<LadderRowPattern> statuses) {
        outputView.printResultMessage();
        outputView.printNames(names);
        outputView.printLadder(statuses);
    }

    private <T> T retryOnException(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return retryOnException(function);
        }
    }
}
