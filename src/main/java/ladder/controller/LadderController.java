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
        this.names = new Names(readNames());
        this.height = new Height(readLadderHeight());

        createLadder(names.size());

        ResultView.printResult(names, ladder);
    }

    private void createLadder(int personCount) {
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.addLine(new Line(personCount, generator));
        }
    }

    private List<String> readNames() {
        try {
            return InputView.requestNames();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readNames();
        }
    }

    private int readLadderHeight() {
        try {
            return InputView.requestLadderHeight();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLadderHeight();
        }
    }


}
