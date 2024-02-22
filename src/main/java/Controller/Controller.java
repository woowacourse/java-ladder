package Controller;

import domain.*;
import dto.HeightRequest;
import dto.PlayersRequest;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Players players = readWithRetry(this::getPlayers);
        final Height height = readWithRetry(this::getHeight);

        final Carpenter carpenter = hireCarpenter(height, players);
        final Ladder ladder = carpenter.makeLadder();

        outputView.printResult(players, ladder);
    }

    private Players getPlayers() {
        final PlayersRequest playersRequest = readWithRetry(inputView::inputPlayers);
        return playersRequest.toPlayers();
    }

    private Height getHeight() {
        final HeightRequest heightRequest = readWithRetry(inputView::inputHeight);
        return heightRequest.toHeigth();
    }

    private Carpenter hireCarpenter(Height height, Players players) {
        return Carpenter.of(height, PlayerCount.fromPlayers(players));
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
