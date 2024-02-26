package laddergame.controller;

import java.util.List;
import laddergame.domain.ladder.LadderHeight;
import laddergame.domain.name.Name;
import laddergame.domain.name.Names;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;
import laddergame.dto.LadderResult;
import laddergame.dto.MatchingResult;
import laddergame.exception.ExceptionHandler;
import laddergame.service.LadderGame;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderController {

    private static final String FIND_ALL_KEY = "all";

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

        outputView.printLadderResult(ladderResult);

        runSelect();
    }

    private Names receiveInputNames() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new Names(inputView.readNames()), outputView);
    }

    private LadderHeight receiveInputLadderHeight() {
        return ExceptionHandler.retryUntilInputIsValid(() -> new LadderHeight(inputView.readLadderHeight()),
                outputView);
    }

    private void runSelect() {
        final String inputName = inputView.readName();
        if (inputName.equals(FIND_ALL_KEY)) {
            printAllResult();
            return;
        }

        printOnceResult(inputName);
        runSelect();
    }

    private void printAllResult() {
        final List<MatchingResult> matchingResults = ladderGame.findResultAll();
        outputView.printMatchingResults(matchingResults);
    }

    private void printOnceResult(final String inputName) {
        final Name name = new Name(inputName);
        final Result result = ladderGame.findResultByName(name);
        outputView.printMatchingResult(result.getResult());
    }

}
