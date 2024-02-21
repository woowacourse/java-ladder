package ladder;

import ladder.contorller.LadderController;
import ladder.domain.direction.DirectionGenerator;
import ladder.domain.direction.DirectionGeneratorImpl;
import ladder.domain.ladder.LineGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        DirectionGenerator DirectionGenerator = new DirectionGeneratorImpl();
        LineGenerator lineGenerator = new LineGenerator(DirectionGenerator);
        LadderController ladderController = new LadderController(inputView, outputView, lineGenerator);

        ladderController.run();
    }
}
