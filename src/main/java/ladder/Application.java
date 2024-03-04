package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.randomGenerator.RandomEnergyGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        OutputView outputView = new OutputView();
        LadderGameController ladderGameController = new LadderGameController(new RandomEnergyGenerator(), inputView,
                outputView);

        ladderGameController.run();
    }
}
