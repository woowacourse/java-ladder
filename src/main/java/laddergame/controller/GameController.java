package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.Names;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class GameController {

    public void process() {
        final Names names = readNames();
        final Ladder ladder = readHeight(names);

        OutputView.printPlayerAll(names);
        OutputView.printLadder(names, ladder);
    }

    private Names readNames() {
        try {
            return new Names(InputView.readNames());
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readNames();
        }
    }

    private Ladder readHeight(final Names names) {
        try {
            return new Ladder(InputView.readHeight(), names.getSize());
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readHeight(names);
        }
    }
}
