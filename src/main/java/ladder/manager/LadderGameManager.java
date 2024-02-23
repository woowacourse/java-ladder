package ladder.manager;

import ladder.controller.LadderGame;
import ladder.exception.ExceptionHandler;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderGameManager {
    public LadderGame createLadderGame() {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final ExceptionHandler exceptionHandler = new ExceptionHandler(outputView);
        return new LadderGame(inputView, outputView, exceptionHandler);
    }
}
