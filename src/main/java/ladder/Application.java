package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(final String[] args) {
        final LadderGameController ladderController = new LadderGameController(
                new InputView(), new OutputView(), new RandomBooleanGenerator()
        );
        ladderController.run();
    }

}
