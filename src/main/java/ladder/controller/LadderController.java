package ladder.controller;

import java.util.List;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
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
        Ladder ladder = createLadder(names, ladderHeight);

        outputView.printLadder(names, results, ladder);
    }

    private Results createResults(int numberOfResults) {
        return new Results(inputView.requestResults(), numberOfResults);
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
