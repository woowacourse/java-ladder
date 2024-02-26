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
        final Ladder ladder = new Ladder(height, PlayerCount.from(players.getCount()));
        final LadderResults ladderResults = createLadderResults(players, ladder, targets);
        outputView.printResult(players, ladder, targets);
        findLadderResult(players, ladderResults);
    }

    private Players readPlayers() {
        final List<String> players = inputView.inputPlayers();
        return Players.from(players);
    }

    private Targets readTargets(Players players) {
        final List<String> targets = inputView.inputTarget();
        return Targets.from(targets, PlayerCount.from(players.getCount()));
    }

    private Height readHeight() {
        final int height = inputView.inputHeight();
        return new Height(height);
    }

    private LadderResults createLadderResults(Players players, Ladder ladder, Targets targets) {
        HashMap<Player, Target> results = new HashMap<>();
        for (Player player : players.getPlayers()) {
            results.put(player, targets.getPrize(ladder.climbLadder(players.getOrder(player))));
        }
        return new LadderResults(results);
    }

    private void findLadderResult(Players players, LadderResults ladderResults) {
        List<Player> results = readWithRetry(() -> players.getCheckPlayers(inputView.inputResult()));
        outputView.printPrize(results, ladderResults.getMatchingTargets(results));
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
