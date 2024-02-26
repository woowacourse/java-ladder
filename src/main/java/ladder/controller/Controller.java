package ladder.controller;

import ladder.domain.DirectionGenerator;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.RandomDirectionGenerator;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {

    public void run() {
        Players players = createPlayers();
        Height height = createHeight();
        DirectionGenerator directionGenerator = new RandomDirectionGenerator();
        Ladder ladder = new Ladder(players, height, directionGenerator);
        ResultView.printResult(players, ladder);
    }

    private Players createPlayers() {
        return ExceptionHandler.run(InputView::inputNames);
    }

    private Height createHeight() {
        return ExceptionHandler.run(InputView::inputHeight);
    }
}
