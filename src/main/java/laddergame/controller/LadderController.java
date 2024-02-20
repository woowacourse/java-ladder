package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.LadderWidth;
import laddergame.domain.Names;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final Names names = new Names(inputView.readNames());
        final LadderHeight height = new LadderHeight(inputView.readLadderHeight());

        final LadderWidth width = LadderWidth.from(names);

        final Ladder ladder = Ladder.create(height, names);

        outputView.printNames(names.getNames(), width.getWidth());
        outputView.printLadder(ladder, width.getWidth(), names.getFirstNameLength());
    }
}
