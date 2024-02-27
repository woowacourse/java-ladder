package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.People;
import ladder.domain.Person;
import ladder.domain.creator.RandomLadderCreator;
import ladder.domain.creator.RandomLineCreator;
import ladder.util.ExceptionRetryHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.List;

public class LadderController {
    private final InputView inputView;
    private final OutputView outputView;

    public LadderController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        People people = requestPeopleUntilValid();
        LadderHeight ladderHeight = requestLadderHeightUntilValid();

        RandomLadderCreator randomLadderCreator = new RandomLadderCreator(new RandomLineCreator());
        Ladder ladder = randomLadderCreator.create(people.getCount() - 1, ladderHeight.getValue());

        outputView.printResult(people, ladder);
    }

    private People requestPeopleUntilValid() {
        return ExceptionRetryHandler.handle(this::requestPeople);
    }

    private People requestPeople() {
        List<String> peopleNames = inputView.readPeopleNames();
        return new People(peopleNames.stream()
                .map(Person::new)
                .toList());
    }

    private LadderHeight requestLadderHeightUntilValid() {
        return ExceptionRetryHandler.handle(this::requestLadderHeight);
    }

    private LadderHeight requestLadderHeight() {
        return new LadderHeight(inputView.readLadderHeight());
    }
}
