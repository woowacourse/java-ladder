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
    private boolean isContinue;

    public LadderController(BooleanGenerator generator) {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.generator = generator;
        this.isContinue = true;
    }

    public void execute() {
        Names names = createNames();
        Bets bets = createBets(names.size());
        Height height = createHeight();
        Ladder ladder = new Ladder(names.size(), height, generator);

        resultView.printForm(names, ladder, bets);
        Result result = ladder.perform(names, bets);

        responseAboutUserRequest(result);
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

    private Bets createBets(int countOfParticipants) {
        try {
            return new Bets(readBets(), countOfParticipants);
        } catch (IllegalArgumentException | NullPointerException e) {
            resultView.printErrorMessage(e.getMessage());
            return createBets(countOfParticipants);
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

    private void responseAboutUserRequest(Result result) {
        while (isContinue) {
            String name = readName();

            printGameResult(result, name);
        }
    }

    private String readName() {
        return inputView.requestName();
    }

    private void printGameResult(Result result, String name) {
        if (ALL.equals(name)) {
            printGameAllResult(result);
            return;
        }
        try {
            resultView.printGameResult(result, new Name(name));
        } catch (IllegalArgumentException e) {
            resultView.printErrorMessage(e.getMessage());
        }
    }

    private void printGameAllResult(Result result) {
        resultView.printGameAllResult(result);
        isContinue = false;
    }

}
