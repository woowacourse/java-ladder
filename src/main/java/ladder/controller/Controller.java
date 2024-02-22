package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.util.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        People people = createNames();
        Height height = createHeight();

        Ladder ladder = new Ladder(people, height);

        outputView.printPeople(people);
        outputView.printLadder(ladder, people);
    }

    private People createNames() {
        return ExceptionHandler.run(this::readNames);
    }

    private People readNames() {
        String names = inputView.readNames();
        return new People(names);
    }

    private Height createHeight() {
        return ExceptionHandler.run(this::readHeight);
    }

    private Height readHeight() {
        String value = inputView.readHeight();
        return new Height(value);
    }
}
