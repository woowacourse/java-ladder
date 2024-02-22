package laddergame.controller;

import laddergame.domain.LadderHeight;
import laddergame.domain.Names;
import laddergame.domain.Result;
import laddergame.service.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderGame ladderGame;

    public LadderController(final InputView inputView, final OutputView outputView, final LadderGame ladderGame) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderGame = ladderGame;
    }

    public void run() {
        final Names names = new Names(inputView.readNames());
        final LadderHeight height = new LadderHeight(inputView.readLadderHeight());

        final Result result = ladderGame.createLadder(names, height);

        outputView.printResult(result);
    }
}
