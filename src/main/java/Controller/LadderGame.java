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
        final Players players = readWithRetry(this::getPlayers);
        final Height height = readWithRetry(this::getHeight);

        final LadderMaker ladderMaker = generateLadderMaker(height, players);
        final Ladder ladder = ladderMaker.makeLadder();

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

    private LadderMaker generateLadderMaker(Height height, Players players) {
        return LadderMaker.of(height, PlayerCount.fromPlayers(players));
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
