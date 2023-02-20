package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.Names;
import laddergame.domain.ConnectionStrategy;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class GameController {

    private final ConnectionStrategy connectionStrategy;

    public GameController(final ConnectionStrategy connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
    }

    public void process() {
        final Names names = readNamesWithRetry();
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
}
