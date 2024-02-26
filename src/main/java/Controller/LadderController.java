package Controller;

import domain.Ladder;
import domain.Player;
import domain.PlayerCount;
import domain.Players;
import domain.RandomStepGenerator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Players players = readWithRetry(this::readPlayers);
        final List<String> prizes = readWithRetry(inputView::inputPrizes, players.getCount());
        final int height = readWithRetry(inputView::inputHeight);

        final Ladder ladder = Ladder.create(height, PlayerCount.fromPlayers(players), new RandomStepGenerator());
        outputView.printLadderMap(players, ladder, prizes);

        final Player searchedPlayer = readWithRetry(this::readSearchingPlayer, players);
//        outputView.printSearchedPrize(searchedPlayer);
    }

    private Players readPlayers() {
        return Players.from(inputView.inputPlayers());
    }

    private Player readSearchingPlayer(Players players) {
        return players.search(inputView.inputSearchingPlayer());
    }

    private <T, R> R readWithRetry(Function<T, R> function, T input) {
        try {
            return function.apply(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readWithRetry(function, input);
        }
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
