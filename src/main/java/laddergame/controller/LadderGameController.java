package laddergame.controller;

import laddergame.model.Height;
import laddergame.model.Ladder;
import laddergame.model.People;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        People people = makePeople();
        Height height = makeLadderHeight();
        Ladder ladder = new Ladder(height, people);
        outputView.printLadderResult(ladder, people);
    }

    private People makePeople() {
        try {
            return new People(inputView.readPersonNames());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return makePeople();
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
