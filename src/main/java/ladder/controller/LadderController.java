package ladder.controller;

import java.util.List;

import ladder.domain.LadderHeight;
import ladder.domain.Ladder;
import ladder.domain.Names;
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
        LadderHeight ladderHeight = createLadderHeight();

        assert names != null;
        assert ladderHeight != null;
        Ladder ladder = createLadder(names, ladderHeight);

        outputView.printResult(names, ladder);
    }

    private Names createNames() {
        Names names = null;
        try {
            names = new Names(readNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            createNames();
        }
        return names;
    }

    private LadderHeight createLadderHeight() {
        LadderHeight ladderHeight = null;
        try {
            ladderHeight = new LadderHeight(readLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            createLadderHeight();
        }
        return ladderHeight;
    }

    private Ladder createLadder(Names names, LadderHeight ladderHeight) {
        return new Ladder(names.size(), ladderHeight.getLadderHeight(), generator);
    }

    private List<String> readNames() {
        return inputView.requestNames();
    }

    private int readLadderHeight() {
        return inputView.requestLadderHeight();
    }

}
