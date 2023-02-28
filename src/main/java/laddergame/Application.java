package laddergame;

import laddergame.controller.LadderGameController;
import laddergame.ladder.LadderGenerator;
import laddergame.ladder.RowGenerator;
import laddergame.view.InputView;
import laddergame.view.ResultView;

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
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }
}
