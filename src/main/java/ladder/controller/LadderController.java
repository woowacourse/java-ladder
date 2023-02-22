package ladder.controller;

import java.util.List;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.MatchingCalculator;
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

        MatchingCalculator matchingCalculator = new MatchingCalculator(ladder, names, results);
        matchingCalculator.calculate();

        inputView.requestNameWantToKnowResult();
    }

    private Ladder createLadder(Names names, Results results, LadderHeight ladderHeight) {
        Ladder ladder = createLadder(names, ladderHeight);
        outputView.printLadder(names, results, ladder);
        return ladder;
    }

    private Results createResults(int numberOfResults) {
        try {
            return new Results(inputView.requestResults(), numberOfResults);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createResults(numberOfResults);
        }
    }

    private Names createNames() {
        try {
            return new Names(readNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createNames();
        }
    }

    private LadderHeight createLadderHeight() {
        try {
            return new LadderHeight(readLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            return createLadderHeight();
        }
    }

    private Ladder createLadder(Names names, LadderHeight ladderHeight) {
        Ladder ladder = new Ladder();
        ladder.drawLine(names.size(), ladderHeight.getLadderHeight(), generator);
        return ladder;
    }

    private List<String> readNames() {
        return inputView.requestNames();
    }

    private int readLadderHeight() {
        return inputView.requestLadderHeight();
    }

}
