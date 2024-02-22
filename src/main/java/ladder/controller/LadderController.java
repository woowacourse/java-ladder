package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.People;
import ladder.util.RandomLinesGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderController {
    public static void start() {
        People people = People.from(InputView.readPeopleNames());
        LadderHeight ladderHeight = LadderHeight.from(InputView.readLadderHeight());

        Ladder ladder = Ladder.create(RandomLinesGenerator::generate, people, ladderHeight);

        OutputView.printResult(people, ladder);
    }
}
