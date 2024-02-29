package laddergame.controller;

import java.util.List;
import laddergame.command.LadderCommand;
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
        final Results results = receiveInputResults(names);
        final LadderHeight height = receiveInputLadderHeight();

        final LadderResult ladderResult = ladderGame.createLadder(names, results, height);

        outputView.printLadderResult(ladderResult);

        printSelectedResult();
    }

    private Names receiveInputNames() {
        return ExceptionHandler.retryBySupplier(() -> new Names(inputView.readNames()), outputView);
    }

    private Results receiveInputResults(final Names names) {
        return ExceptionHandler.retryBySupplier(() -> new Results(inputView.readResults(), names.size()),
                outputView);
    }

    private LadderHeight receiveInputLadderHeight() {
        return ExceptionHandler.retryBySupplier(() -> new LadderHeight(inputView.readLadderHeight()),
                outputView);
    }

    private void printSelectedResult() {
        ExceptionHandler.retryByRunnable(this::runSelect, outputView);
    }

    private void runSelect() {
        final String inputName = inputView.readName();
        if (LadderCommand.isAllCommand(inputName)) {
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
