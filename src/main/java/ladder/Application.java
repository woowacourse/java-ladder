package ladder;

import ladder.controller.LadderGameController;
import ladder.controller.LadderResultController;
import ladder.domain.randomGenerator.RandomEnergyGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        OutputView outputView = new OutputView();
        LadderGameController ladderGameController = new LadderGameController(new RandomEnergyGenerator(), inputView,
                outputView);
        LadderResultController ladderResultController = ladderGameController.run();

        ladderResultController.checkResult();
    }
}
