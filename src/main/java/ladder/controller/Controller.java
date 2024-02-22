package ladder.controller;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.LineGenerator;
import ladder.domain.Players;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {

    public void run() {
        Players players = createPeople();
        Height height = createHeight();
        Ladder ladder = new Ladder(players, height);
        ladder.initialize(new LineGenerator());
        ResultView.printResult(players, ladder);
    }

    private Players createPeople() {
        return ExceptionHandler.run(InputView::inputNames);
    }

    private Height createHeight() {
        return ExceptionHandler.run(InputView::inputHeight);
    }
}
