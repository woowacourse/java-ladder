package ladder.controller;

import ladder.domain.DefaultLineGenerator;
import ladder.domain.Ladder;
import ladder.domain.People;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {

    public void run() {
        People people = new People(InputView.inputNames());
        int height = InputView.inputHeight();
        Ladder ladder = new Ladder(people.count(), height);
        ladder.initialize(new DefaultLineGenerator());
        ResultView.printResult(people, ladder);
    }
}
