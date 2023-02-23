package ladder.controller;

import java.util.List;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.MatchingCalculator;
import ladder.domain.Matchings;
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
        Names names = createNames();
        Results results = createResults(names.size());
        LadderHeight ladderHeight = createLadderHeight();

        Ladder ladder = createLadder(names, results, ladderHeight);

        calculateMatchingResult(names, results, ladder);
    }

    private Names createNames() {
        try {
            return new Names(readNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createNames();
        }
    }

    private List<String> readNames() {
        return inputView.requestNames();
    }

    private Results createResults(int numberOfResults) {
        try {
            return new Results(readResults(), numberOfResults);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createResults(numberOfResults);
        }
    }

    private List<String> readResults() {
        return inputView.requestResults();
    }

    private LadderHeight createLadderHeight() {
        try {
            return new LadderHeight(readLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createLadderHeight();
        }
    }

    private int readLadderHeight() {
        return inputView.requestLadderHeight();
    }

    private Ladder createLadder(Names names, Results results, LadderHeight ladderHeight) {
        Ladder ladder = makeLadder(names, ladderHeight);
        outputView.printLadder(names, results, ladder);
        return ladder;
    }

    private Ladder makeLadder(Names names, LadderHeight ladderHeight) {
        Ladder ladder = new Ladder();
        ladder.drawLine(names.size(), ladderHeight.getLadderHeight(), generator);
        return ladder;
    }

    private void calculateMatchingResult(Names names, Results results, Ladder ladder) {
        MatchingCalculator matchingCalculator = new MatchingCalculator(ladder, names, results);
        Matchings matchings = matchingCalculator.calculate();

        match(matchings);
    }

    private void match(Matchings matchings) {
        try {
            printMatchResult(matchings);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            match(matchings);
        }
    }

    private void printMatchResult(Matchings matchings) {
        while (!matchings.isAllChecked()) {
            String nameWantToKnowResult = inputView.requestNameWantToKnowResult();
            outputView.printMatching(matchings.getMatchingResult(nameWantToKnowResult));
        }
    }

}
