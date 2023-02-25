package laddergame.controller;

import laddergame.model.Height;
import laddergame.model.Ladder;
import laddergame.model.Persons;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Persons persons = makePersons();
        Height height = makeLadderHeight();
        Ladder ladder = new Ladder(height, persons);
        outputView.printLadderResult(ladder, persons);
    }

    private Persons makePersons() {
        try {
            return new Persons(inputView.readPersonNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return makePersons();
        }
    }

    private Height makeLadderHeight() {
        try {
            return new Height(inputView.readLadderHeight());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return makeLadderHeight();
        }
    }
}
