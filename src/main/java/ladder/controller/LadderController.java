package ladder.controller;

import ladder.service.LadderService;
import ladder.util.BooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LadderService ladderService;

    public LadderController(BooleanGenerator generator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.ladderService = new LadderService(generator);
    }

    public void execute() {
        readNames();
        readResults();
        readLadderHeight();
        outputView.printLadderShape(ladderService.createLadder());

        ladderService.matchNamesWithResults();

        searchResult();
    }

    private void readNames() {
        try {
            ladderService.readNames(inputView.requestNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            readNames();
        }
    }

    private void readResults() {
        try {
            ladderService.readResults(inputView.requestResults());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            readResults();
        }
    }

    private void readLadderHeight() {
        try {
            ladderService.readLadderHeight(inputView.requestLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            readLadderHeight();
        }
    }

    private void searchResult() {
        try {
            printResult();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            searchResult();
        }
    }

    private void printResult() {
        while (!ladderService.isAllResultChecked()) {
            outputView.printMatchResult(ladderService.findMatchResult(inputView.requestNameWantToKnowResult()));
        }
    }
}
