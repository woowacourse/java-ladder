package laddergame.controller;

import laddergame.domain.LadderHeight;
import laddergame.domain.Names;
import laddergame.dto.Result;
import laddergame.exception.ExceptionHandler;
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
        final Names names = getNames();
        final LadderHeight height = getLadderHeight();

        final Result result = ladderGame.createLadder(names, height);

        outputView.printResult(result);
    }

    private Names getNames() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new Names(inputView.readNames()), outputView);
    }

    private LadderHeight getLadderHeight() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new LadderHeight(inputView.readLadderHeight()),
                outputView);
    }

}
