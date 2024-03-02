package ladder;

import ladder.controller.LadderController;
import ladder.domain.ladder.RandomRungGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(System.in);
        OutputView outputView = new OutputView();
        RandomRungGenerator rungGenerator = new RandomRungGenerator();

        LadderController ladderController = new LadderController(inputView, outputView, rungGenerator);
        ladderController.run();
    }
}
