package ladder;

import ladder.controller.LadderController;
import ladder.domain.randomGenerator.RandomEnergyGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);

        OutputView outputView = new OutputView();
        LadderController ladderController = new LadderController(new RandomEnergyGenerator(), inputView, outputView);
        ladderController.run();
    }
}
