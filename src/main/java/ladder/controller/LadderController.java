package ladder.controller;

import java.util.List;

import ladder.domain.Ladder;
import ladder.domain.LadderFactory;
import ladder.domain.LadderHeight;
import ladder.domain.MatchResults;
import ladder.domain.Matcher;
import ladder.domain.Names;
import ladder.domain.Results;
import ladder.util.BooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator generator;

    public LadderController(BooleanGenerator generator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.generator = generator;
    }

    public void execute() {
        Names names = readNames();
        Results results = readResults(names.size());
        LadderHeight ladderHeight = readLadderHeight();
        Ladder ladder = createLadder(names, ladderHeight);
        outputView.printLadderShape(names, results, ladder);
        MatchResults matchResults = matchNamesWithResults(names, results, ladder);
        searchResult(matchResults);
    }

    private Names readNames() {
        try {
            return new Names(requestNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readNames();
        }
    }

    private List<String> requestNames() {
        return inputView.requestNames();
    }

    private Results readResults(int numberOfResults) {
        try {
            return new Results(requestResults(), numberOfResults);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readResults(numberOfResults);
        }
    }

    private List<String> requestResults() {
        return inputView.requestResults();
    }

    private LadderHeight readLadderHeight() {
        try {
            return new LadderHeight(requestLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return readLadderHeight();
        }
    }

    private int requestLadderHeight() {
        return inputView.requestLadderHeight();
    }

    private Ladder createLadder(Names names, LadderHeight ladderHeight) {
        return LadderFactory.newLadder(names.size(), ladderHeight.getLadderHeight(), generator);
    }

    private MatchResults matchNamesWithResults(Names names, Results results, Ladder ladder) {
        Matcher matcher = new Matcher(ladder, names, results);
        return matcher.match();
    }

    private void searchResult(MatchResults matchResults) {
        try {
            printResult(matchResults);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            searchResult(matchResults);
        }
    }

    private void printResult(MatchResults matchResults) {
        while (!matchResults.isAllChecked()) {
            String nameWantToKnowResult = inputView.requestNameWantToKnowResult();
            outputView.printMatchResult(matchResults.findMatchResult(nameWantToKnowResult));
        }
    }
}
