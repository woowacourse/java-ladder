package laddergame.controller;

import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.name.Names;
import laddergame.domain.result.Results;
import laddergame.dto.LadderResult;
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
        final Names names = receiveInputNames();
        final Results results = new Results(inputView.readResults());
        final LadderHeight height = receiveInputLadderHeight();

        final LadderResult ladderResult = ladderGame.createLadder(names, results, height);



        outputView.printResult(ladderResult);
    }

    private Names receiveInputNames() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new Names(inputView.readNames()), outputView);
    }

    private LadderHeight receiveInputLadderHeight() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new LadderHeight(inputView.readLadderHeight()),
                outputView);
    }

}
