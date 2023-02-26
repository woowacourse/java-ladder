package ladder;

import ladder.controller.LadderController;
import ladder.domain.RandomBarGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(
                new InputView(), new OutputView(), new RandomBarGenerator());
        ladderController.run();
    }
}
