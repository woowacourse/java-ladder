package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(
                new InputView(),
                new OutputView(),
                new RandomBooleanGenerator());
        ladderGameController.run();
    }
}
