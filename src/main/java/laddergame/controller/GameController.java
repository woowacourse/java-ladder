package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.Names;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class GameController {

    public void process() {
        final Names names = new Names(InputView.readNames());
        final Ladder ladder = new Ladder(InputView.readFloor(), names.getSize());
        OutputView.printPlayerAll(names);
        OutputView.printLadder(names.findMaxNameLength(), ladder);
    }
}
