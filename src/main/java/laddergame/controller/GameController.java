package laddergame.controller;

import laddergame.domain.Height;
import laddergame.domain.Ladder;
import laddergame.domain.Names;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class GameController {

    public void process() {
        final Names names = readNames();
        final Height height = readHeight();
        final Ladder ladder = new Ladder(height, names.getSize());

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

    private Height readHeight() {
        try {
            return new Height(InputView.readHeight());
        } catch (IllegalStateException | IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            return readHeight();
        }
    }
}
