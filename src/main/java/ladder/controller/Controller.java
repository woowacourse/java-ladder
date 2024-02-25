package ladder.controller;

import ladder.domain.DefaultLadderDirectionSelector;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Controller {

    public void run() {
        Players players = createPlayers();
        Height height = createHeight();
        Ladder ladder = Ladder.of(players, height, new DefaultLadderDirectionSelector());
        ResultView.printResult(players, ladder);
    }

    private Players createPlayers() {
        return ExceptionHandler.run(InputView::inputNames);
    }

    private Height createHeight() {
        return ExceptionHandler.run(InputView::inputHeight);
    }
}
