package ladder.controller;

import ladder.domain.LadderHeight;
import ladder.domain.People;
import ladder.view.InputView;

public class LadderController {
    public static void start() {
        People people = People.from(InputView.readPeopleNames());
        LadderHeight ladderHeight = LadderHeight.from(InputView.readLadderHeight());
    }
}
