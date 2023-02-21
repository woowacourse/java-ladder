package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Names;
import ladder.util.BooleanGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private final InputView inputView;
    private final ResultView resultView;
    private final BooleanGenerator generator;

    public LadderController(BooleanGenerator generator) {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.generator = generator;
    }

    public void execute() {
        Names names = createNames();
        Height height = createHeight();

        Ladder ladder = new Ladder(names.size(), height, generator);

        resultView.printResult(names, ladder);
    }

    private Names createNames() {
        try {
            return new Names(readNames());
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return createNames();
        }
    }

    private List<String> readNames() {
        return inputView.requestNames();
    }

    private Height createHeight() {
        try {
            return new Height(readLadderHeight());
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return createHeight();
        }
    }

    private int readLadderHeight() {
        return inputView.requestLadderHeight();
    }

}
