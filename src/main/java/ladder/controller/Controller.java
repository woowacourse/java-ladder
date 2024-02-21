package ladder.controller;

import ladder.domain.DefaultLineGenerator;
import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {

    public void run() {
        People people = createPeople();
        int height = createHeight();
        Ladder ladder = new Ladder(people.count(), height);
        ladder.initialize(new DefaultLineGenerator());
        ResultView.printResult(people, ladder);
    }

    private People createPeople() {
        return ExceptionHandler.run(InputView::inputNames);
    }

    private int createHeight() {
        return ExceptionHandler.run(InputView::inputHeight);
    }
}
