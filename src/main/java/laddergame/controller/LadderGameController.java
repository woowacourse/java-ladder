package laddergame.controller;

import laddergame.model.Height;
import laddergame.model.Ladder;
import laddergame.model.Persons;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        Persons persons = makePersons();
        Height height = makeLadderHeight();
        Ladder ladder = new Ladder(height, persons);
        outputView.printResult(ladder, persons);
    }

    private Persons makePersons() {
        try {
            return new Persons(inputView.readPersonNames());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makePersons();
        }
    }

    private Height makeLadderHeight() {
        try {
            return new Height(inputView.readLadderHeight());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makeLadderHeight();
        }
    }
}
