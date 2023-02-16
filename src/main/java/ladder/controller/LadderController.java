package ladder.controller;

import java.util.List;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Names;
import ladder.util.BooleanGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class LadderController {
    private final BooleanGenerator generator;
    private final Ladder ladder;
    private Names names;
    private Height height;

    public LadderController(BooleanGenerator generator) {
        this.generator = generator;
        this.ladder = new Ladder();
    }

    public void execute() {
        createNames();
        createHeight();

        createLadder(names.size());

        ResultView.printResult(names, ladder);
    }

    private void createNames() {
        try {
            this.names = new Names(readNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createNames();
        }
    }

    private void createHeight() {
        try {
            this.height = new Height(readLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createHeight();
        }
    }

    private void createLadder(int personCount) {
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.addLine(new Line(personCount, generator));
        }
    }

    private List<String> readNames() {
        return InputView.requestNames();
    }

    private int readLadderHeight() {
        return InputView.requestLadderHeight();
    }

}
