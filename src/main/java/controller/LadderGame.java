package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.function.Supplier;

public class LadderGame {
    public static final String ALL = "all";
    
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
        final LadderResults ladderResults = LadderResults.of(players, ladder, targets);
        
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

    private void findLadderResult(Players players, LadderResults ladderResults) {
        String result = inputView.inputResult();
        if (result.equals(ALL)) {
            List<Player> results = players.getAllPlayers();
            outputView.printAllPrize(results, ladderResults.getMatchingTargets(results));
            return;
        }
        outputView.printPrize(ladderResults.getMatchingTarget(players.getCheckPlayer(result)));
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
