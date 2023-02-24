package laddergame.controller;

import laddergame.domain.ladder.ConnectionStrategy;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.ladder.LadderGame;
import laddergame.domain.player.Name;
import laddergame.domain.player.Names;
import laddergame.domain.player.Players;
import laddergame.domain.prize.Prizes;
import laddergame.domain.prize.Result;
import laddergame.domain.prize.Results;
import laddergame.view.InputView;
import laddergame.view.OutputView;

import java.util.List;

public class GameController {
    
    private final Names names;
    private final Prizes prizes;
    private final Ladder ladder;

    public GameController(final ConnectionStrategy connectionStrategy) {
        this.names = readNamesWithRetry();
        this.prizes = readPrizesWithRetry(names.getSize());
        this.ladder = createdLadder(connectionStrategy);
    }

    private Names readNamesWithRetry() {
        try {
            return new Names(InputView.readNames());
        } catch (final IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readNamesWithRetry();
        }
    }

    private Prizes readPrizesWithRetry(final int size) {
        try {
            return new Prizes(InputView.readResults(), size);
        } catch (final IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readPrizesWithRetry(size);
        }
    }

    private Ladder createdLadder(final ConnectionStrategy connectionStrategy) {
        try {
            final int height = InputView.readHeight();
            return new Ladder(height, names.getSize(), connectionStrategy);
        } catch (final IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readLadderHeightWithRetry(names, connectionStrategy);
        }
    }

    private Ladder readLadderHeightWithRetry(final Names names, final ConnectionStrategy connectionStrategy) {
        try {
            return new Ladder(InputView.readHeight(), names.getSize(), connectionStrategy);
        } catch (final IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readLadderHeightWithRetry(names, connectionStrategy);
        }
    }

    public void process() {
        printCreatedLadderAndPrizes(names, prizes, ladder);

        final Results results = startLadderGame(names, prizes, ladder);

        while (true) {
            findResultWithRetry(results);
        }
    }

    private static void printCreatedLadderAndPrizes(final Names names, final Prizes prizes, final Ladder ladder) {
        OutputView.printPlayerAll(names);
        OutputView.printLadder(names, ladder);
        OutputView.printPrizesAll(prizes, names.findMaxNameLength());
    }

    private static Results startLadderGame(final Names names, final Prizes prizes, final Ladder ladder) {
        final LadderGame ladderGame = new LadderGame(ladder, new Players(names), prizes);
        ladderGame.startGame();
        return ladderGame.createResults();
    }

    private void findResultWithRetry(final Results results) {
        try {
            final Name resultName = new Name(InputView.readResultPlayerName());
            final List<Result> result = results.findResults(resultName);
            OutputView.printResult(result);
        } catch (final IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
        }
    }
}
