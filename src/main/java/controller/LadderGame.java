package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.HashMap;
import java.util.List;
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
        final Targets targets = readWithRetry(() -> readTargets(players));
        final Height height = readWithRetry(this::readHeight);

        final Ladder ladder = Ladder.create(height, PlayerCount.fromPlayers(players));

        outputView.printResult(players, ladder, targets);

        findLadderResult(players, ladder, targets);
    }

    private void findLadderResult(Players players, Ladder ladder, Targets targets) {
        HashMap<Player, Target> results = new HashMap<>();
        for (Player player : players.getPlayers()) {
            results.put(player, targets.getPrize(ladder.climbLadder(players.getOrder(player))));
        }
        String result = inputView.inputResult();
        outputView.printPrize(new Player(result), results.get(new Player(result)));
    }

    private Players readPlayers() {
        final List<String> players = readWithRetry(inputView::inputPlayers);
        return Players.from(players);
    }

    private Targets readTargets(Players players) {
        final List<String> targets = readWithRetry(inputView::inputTargets);
        return Targets.from(targets, PlayerCount.fromPlayers(players));
    }

    private Height readHeight() {
        final int height = readWithRetry(inputView::inputHeight);
        return new Height(height);
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
