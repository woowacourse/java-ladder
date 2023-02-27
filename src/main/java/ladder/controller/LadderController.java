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

        while (response(result)) {
        }
    }

    private Names createNames() {
        try {
            return new Names(readNames());
        } catch (IllegalArgumentException | NullPointerException e) {
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
            return new Result(names, createBets());
        } catch (IllegalArgumentException | NullPointerException e) {
            resultView.printErrorMessage(e.getMessage());
            return createResult(names);
        }
    }

    private Bets createBets() {
        try {
            return new Bets(readBets());
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return createBets();
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

    private boolean response(Result result) {
        String name = readName();

        try {
            return printGameResult(result, name);
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
            return response(result);
        }
    }

    private boolean printGameResult(Result result, String name) {
        if (ALL.equals(name)) {
            resultView.printGameAllResult(result);
            return false;
        }

        resultView.printGameResult(result, new Name(name));
        return true;
    }

}