package laddergame.controller;

import laddergame.domain.Ladder;
import laddergame.domain.LadderHeight;
import laddergame.domain.Names;
import laddergame.domain.RandomBooleanGenerator;
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
        final LadderHeight ladderHeight = new LadderHeight(inputView.readLadderHeight());

        final Ladder ladder = Ladder.create(ladderHeight.getValue(), names.size(), new RandomBooleanGenerator());
        final int width = ladder.getWidth(names);

        outputView.printNames(names.getNames(), width);
        outputView.printLadder(ladder, width, names.getFirstNameLength());
    }
}
