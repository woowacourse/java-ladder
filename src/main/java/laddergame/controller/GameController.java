package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.Names;
import laddergame.domain.PickStrategy;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class GameController {

    private final PickStrategy pickStrategy;

    public GameController(final PickStrategy pickStrategy) {
        this.pickStrategy = pickStrategy;
    }

    public void process() {
        final Names names = readNamesWithRetry();
        final Ladder ladder = readHeightWithRetry(names, pickStrategy);

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

    private Ladder readHeightWithRetry(final Names names, final PickStrategy pickStrategy) {
        try {
            return new Ladder(InputView.readHeight(), names.getSize(), pickStrategy);
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readHeightWithRetry(names, pickStrategy);
        }
    }
}
