package Controller;

import domain.Ladder;
import domain.PlayerCount;
import domain.RandomStepGenerator;
import java.util.List;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final List<String> players = readWithRetry(inputView::inputPlayers);
        final int height = readWithRetry(inputView::inputHeight);

        final Ladder ladder = Ladder.create(height, PlayerCount.fromPlayers(players), new RandomStepGenerator());

        outputView.printResult(players, ladder);
    }

    private <T> T readWithRetry(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWithRetry(supplier);
        }
    }
}
