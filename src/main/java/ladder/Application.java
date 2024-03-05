package ladder;

import ladder.contorller.LadderController;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LadderController ladderController = new LadderController(inputView, outputView);
        ladderController.run();
    }
}
