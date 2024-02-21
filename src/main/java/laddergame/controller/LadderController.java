package laddergame.controller;

import laddergame.domain.LadderGame;
import laddergame.domain.LadderHeight;
import laddergame.domain.Names;
import laddergame.domain.RandomBooleanGenerator;
import laddergame.domain.Result;
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

        final LadderGame ladderGame = LadderGame.create(names, height, new RandomBooleanGenerator());
        final Result result = ladderGame.getResult();

        outputView.printResult(result);
    }
}
