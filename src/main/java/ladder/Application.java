package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.BooleanGenerator;
import ladder.domain.LadderGenerator;
import ladder.domain.RandomBooleanGenerator;
import ladder.domain.RowGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Application {
    public static void main(String[] args) {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        RowGenerator rowGenerator = new RowGenerator(booleanGenerator);
        LadderGenerator ladderGenerator = new LadderGenerator(rowGenerator);

        LadderGameController ladderGameController = new LadderGameController(new InputView(), new ResultView(), ladderGenerator);
        try {
            ladderGameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
