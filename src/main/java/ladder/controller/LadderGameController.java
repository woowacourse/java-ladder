package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.util.ExceptionHandledReader;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameController {
    private LadderGameController() {
    }

    public static void run() {
        People people = ExceptionHandledReader.readUntilNoError(LadderGameController::getPeople);
        Ladder ladder = ExceptionHandledReader.readUntilNoError(() -> getLadder(people));

        OutputView.printNames(people);
        OutputView.printLadder(ladder);
    }

    private static People getPeople() {
        return new People(InputView.readNames());
    }

    private static Ladder getLadder(People people) {
        int peopleNumber = people.getNames().size();
        return new Ladder(InputView.readHeight(), peopleNumber);
    }

}
