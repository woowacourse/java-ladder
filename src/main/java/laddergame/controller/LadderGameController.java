package laddergame.controller;

import laddergame.model.Ladder.Height;
import laddergame.model.Ladder.Ladder;
import laddergame.model.Participants;
import laddergame.view.InputView;
import laddergame.view.OutputView;

public class LadderGameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        Participants participants = makePersons();
        Height height = makeLadderHeight();
        Ladder ladder = new Ladder(height, participants);
        outputView.printResult(ladder, participants);
        inputView.closeScanner();
    }

    private Participants makePersons() {
        try {
            return new Participants(inputView.readPersonNames());
        } catch (IllegalArgumentException e) {
            inputView.printErrorMsg(e.getMessage());
            return makePersons();
        }
    }

    private Height makeLadderHeight() {
        try {
            return new Height(inputView.readLadderHeight());
        } catch (IllegalArgumentException e) {
            inputView.printErrorMsg(e.getMessage());
            return makeLadderHeight();
        }
    }
}
