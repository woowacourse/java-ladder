package ladder;


import ladder.controller.LadderController;
import ladder.domain.ladder.generator.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        new LadderController(
                new InputView(),
                new OutputView(),
                new RandomBooleanGenerator()
        ).run();
    }
}
