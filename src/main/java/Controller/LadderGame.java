package Controller;

import domain.*;
import dto.HeightRequest;
import dto.PlayersRequest;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class LadderGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Players players = readWithRetry(this::readPlayers);
        final Height height = readWithRetry(this::readHeight);

        final Ladder ladder = Ladder.create(height, PlayerCount.fromPlayers(players));

        outputView.printResult(players, ladder);
    }

    private Players readPlayers() {
        final PlayersRequest playersRequest = readWithRetry(inputView::inputPlayers);
        return playersRequest.toPlayers();
    }

    private Height readHeight() {
        final HeightRequest heightRequest = readWithRetry(inputView::inputHeight);
        return heightRequest.toHeight();
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
