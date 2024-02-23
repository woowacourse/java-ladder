package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.People;
import ladder.domain.Person;
import ladder.util.ExceptionRetryHandler;
import ladder.util.RandomLinesGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    private LadderController() {
    }

    public static void start() {
        People people = requestPeopleUntilValid();
        LadderHeight ladderHeight = requestLadderHeightUntilValid();

        Ladder ladder = Ladder.create(RandomLinesGenerator::generate, people, ladderHeight);

        OutputView.printResult(people, ladder);
    }

    private static People requestPeopleUntilValid() {
        return ExceptionRetryHandler.handle(LadderController::requestPeople);
    }

    private static People requestPeople() {
        List<String> peopleNames = InputView.readPeopleNames();
        return new People(peopleNames.stream()
                .map(Person::new)
                .toList());
    }

    private static LadderHeight requestLadderHeightUntilValid() {
        return ExceptionRetryHandler.handle(LadderController::requestLadderHeight);
    }

    private static LadderHeight requestLadderHeight() {
        return new LadderHeight(InputView.readLadderHeight());
    }
}
