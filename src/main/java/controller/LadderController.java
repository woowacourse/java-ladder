package controller;

import domain.RandomBooleanSupplier;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.PlayerCount;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import domain.result.GameResult;
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

        final Ladder ladder = Ladder.create(height, PlayerCount.fromPlayers(players), new RandomBooleanSupplier());
        outputView.printLadderMap(players, ladder, prizes);

        showGameResult(GameResult.of(ladder, players, prizes), players);
    }

    private Players readPlayers() {
        return Players.from(inputView.inputPlayers());
    }

    private Prizes readPrizes(final Players players) {
        final List<String> prizes = inputView.inputPrizes(players.getCount());
        return Prizes.from(prizes);
    }

    private Height readHeight(final int height) {
        return new Height(height);
    }

    private void showGameResult(final GameResult gameResult, final Players players) {
        String command = readWithRetry(this::readSearchingPlayers, players);

        while (!command.equals("all")){
            final Prize prize = gameResult.search(new Player(command));
            outputView.printGameResult(prize);
            command = inputView.inputSearchingPlayer();
        }
        outputView.printGameResult(gameResult);
    }

    private String readSearchingPlayers(final Players players) {
        final String inputName = readWithRetry(inputView::inputSearchingPlayer);
        players.validateExistPlayer(inputName);
        return inputName;
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
