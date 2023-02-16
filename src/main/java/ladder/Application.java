package ladder;

import ladder.Controller.LadderGameController;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(InputView.getInstance(), OutputView.getInstance());
        ladderGameController.run();
    }
}
