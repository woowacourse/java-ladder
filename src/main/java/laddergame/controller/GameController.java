package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.Names;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class GameController {

    public void process() {
        final Names names = readNamesWithRetry();
        final Ladder ladder = readHeightWithRetry(names);

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

    private Ladder readHeightWithRetry(final Names names) {
        try {
            return new Ladder(InputView.readHeight(), names.getSize());
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readHeightWithRetry(names);
        }
    }
}
