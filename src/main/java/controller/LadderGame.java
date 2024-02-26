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
        final Ladder ladder = Ladder.create(height, PlayerCount.from(players.getCount()));
        final LadderResults ladderResults = createLadderResults(players, ladder, targets);
        outputView.printResult(players, ladder, targets);
        findLadderResult(players, ladderResults);
    }

    private LadderResults createLadderResults(Players players, Ladder ladder, Targets targets) {
        HashMap<Player, Target> results = new HashMap<>();
        for (Player player : players.getPlayers()) {
            results.put(player, targets.getPrize(ladder.climbLadder(players.getOrder(player))));
        }
        return new LadderResults(results);
    }

    private void findLadderResult(Players players, LadderResults ladderResults) {
        String result = inputView.inputResult();
        List<Player> results = players.getCheckPlayers(result);
        outputView.printPrize(results, ladderResults.getMatchingTargets(results));
    }

    private Players readPlayers() {
        final List<String> players = readWithRetry(inputView::inputPlayers);
        return Players.from(players);
    }

    private Targets readTargets(Players players) {
        final List<String> targets = readWithRetry(inputView::inputTargets);
        return Targets.from(targets, PlayerCount.from(players.getCount()));
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
