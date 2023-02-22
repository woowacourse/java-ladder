package laddergame.controller;

import laddergame.domain.Prizes;
import laddergame.domain.ladder.ConnectionStrategy;
import laddergame.domain.ladder.Ladder;
import laddergame.domain.player.Names;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class GameController {

    private final ConnectionStrategy connectionStrategy;

    public GameController(final ConnectionStrategy connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
    }

    public void process() {
        final Names names = readNamesWithRetry();
        final Prizes prizes = readResultWithRetry(names.getSize());
        final Ladder ladder = readHeightWithRetry(names, connectionStrategy);

        OutputView.printPlayerAll(names);
        OutputView.printLadder(names, ladder);
    }

    private Names readNamesWithRetry() {
        try {
            return new Names(InputView.readNames());
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readNamesWithRetry();
        }
    }

    private Ladder readHeightWithRetry(final Names names, final ConnectionStrategy connectionStrategy) {
        try {
            return new Ladder(InputView.readHeight(), names.getSize(), connectionStrategy);
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readHeightWithRetry(names, connectionStrategy);
        }
    }

    private Prizes readResultWithRetry(final int size) {
        try {
            return new Prizes(InputView.readResults(), size);
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readResultWithRetry(size);
        }
    }
}
