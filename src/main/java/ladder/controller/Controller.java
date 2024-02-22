package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LineGenerator;
import ladder.domain.People;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {

    public void run() {
        People people = createPeople();
        Height height = createHeight();
        Ladder ladder = new Ladder(people, height);
        ladder.initialize(new LineGenerator());
        ResultView.printResult(people, ladder);
    }

    private People createPeople() {
        return ExceptionHandler.run(InputView::inputNames);
    }

    private Height createHeight() {
        return ExceptionHandler.run(InputView::inputHeight);
    }
}
