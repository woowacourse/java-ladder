package ladder;

import ladder.controller.InputController;
import ladder.controller.LadderGameController;
import ladder.controller.ResultController;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController(new InputView());
        ResultController resultController = new ResultController(new ResultView());
        LadderGameController ladderGameController = new LadderGameController(inputController, resultController);
        ladderGameController.run();
    }
}
