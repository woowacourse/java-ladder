package ladder.controller;

import ladder.domain.*;
import ladder.util.BooleanGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

import java.util.List;

public class LadderController {
    private static final String ALL = "all";

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
        Result result = createResult(names);
        Height height = createHeight();
        Ladder ladder = new Ladder(names.size(), height, generator);

        resultView.printForm(names, ladder, result);

        result.perform(ladder);

        while (response(names, result)) {
        }
    }

    private boolean response(Names names, Result result) {
        String name = readName();

        try {
            return printGameResult(names, result, name);
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return response(names, result);
        }
    }

    private boolean printGameResult(Names names, Result result, String name) {
        if (name.equals(ALL)) {
            resultView.printGameResult(names, result);
            return false;
        }

        resultView.printGameResult(result, names.indexOf(new Name(name)));
        return true;
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

    private String readName() {
        return inputView.requestName();
    }

    private Result createResult(Names names) {
        try {
            return new Result(names, readBets());
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return createResult(names);
        }
    }

    private List<String> readBets() {
        return inputView.requestBets();
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
