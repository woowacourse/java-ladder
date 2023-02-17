package ladder.controller;

import java.util.List;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Names;
import ladder.util.BooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;
    private final BooleanGenerator generator;
    private final Ladder ladder;
    private Names names;
    private Height height;

    public LadderController(BooleanGenerator generator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.generator = generator;
        this.ladder = new Ladder();
    }

    public void execute() {
        createNames();
        createHeight();

        createLadder(names.size());

        outputView.printResult(names, ladder);
    }

    private void createNames() {
        try {
            this.names = new Names(readNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            createNames();
        }
    }

    private void createHeight() {
        try {
            this.height = new Height(readLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e);
            createHeight();
        }
    }

    private void createLadder(int personCount) {
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.addLine(new Line(personCount, generator));
        }
    }

    private List<String> readNames() {
        return inputView.requestNames();
    }

    private int readLadderHeight() {
        return inputView.requestLadderHeight();
    }

}
