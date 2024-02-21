package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.People;
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
        Ladder ladder = new Ladder(height, people);

        outputView.printResult(people, ladder);
    }

    private People createNames() {
        String names = inputView.readNames();
        try {
            return new People(names);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createNames();
        }
    }

    private Height createHeight() {
        int value = inputView.readHeight();
        try {
            return new Height(value);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return createHeight();
        }
    }
}
