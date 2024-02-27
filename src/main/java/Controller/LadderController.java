package Controller;

import domain.Height;
import domain.Ladder;
import domain.LadderGame;
import domain.PlayerCount;
import domain.Players;
import domain.PlayersPrize;
import domain.Prize;
import domain.Prizes;
import domain.RandomStepGenerator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Players players = readWithRetry(this::readPlayers);
        final Prizes prizes = readWithRetry(this::readPrizes, players);
        final Height height = readWithRetry(this::readHeight, inputView.inputHeight());

        final Ladder ladder = Ladder.create(height, PlayerCount.fromPlayers(players), new RandomStepGenerator());
        outputView.printLadderMap(players, ladder, prizes);

        final LadderGame ladderGame = new LadderGame(ladder, players, prizes);
        showGameResult(ladderGame.getPlayersPrize(), players);
    }

    private Players readPlayers() {
        return Players.from(inputView.inputPlayers());
    }

    private Prizes readPrizes(Players players) {
        final List<String> prizes = inputView.inputPrizes(players.getCount());
        return Prizes.from(prizes);
    }

    private Height readHeight(int height) {
        return new Height(height);
    }

    private void showGameResult(PlayersPrize playersPrize, Players players) {
        final Players searchedPlayer = readWithRetry(this::readSearchingPlayers, players);

        if (searchedPlayer.isCountOne()) {
            final Prize prize = playersPrize.searchOnePlayerPrize(searchedPlayer);
            outputView.printGameResult(prize);
            showGameResult(playersPrize, players);
        }
        if (!searchedPlayer.isCountOne()) {
            outputView.printGameResult(playersPrize);
        }
    }

    private Players readSearchingPlayers(Players players) {
        final String inputName = readWithRetry(inputView::inputSearchingPlayer);
        return players.search(inputName);
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
