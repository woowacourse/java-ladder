package ladder.controller;

import java.util.List;

import ladder.domain.Height;
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
        Height height = createHeight();

        assert names != null;
        assert height != null;
        Ladder ladder = createLadder(names, height);

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

    private Height createHeight() {
        Height height = null;
        try {
            height = new Height(readLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            createHeight();
        }
        return height;
    }

    private Ladder createLadder(Names names, Height height) {
        return new Ladder(names.size(), height.getHeight(), generator);
    }

    private List<String> readNames() {
        return inputView.requestNames();
    }

    private int readLadderHeight() {
        return inputView.requestLadderHeight();
    }

}
