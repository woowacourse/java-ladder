package ladder;

import ladder.controller.LadderGameController;
import ladder.domain.LadderGenerator;
import ladder.view.InputView;
import ladder.view.ResultView;

public class Application {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new InputView(), new ResultView(), new LadderGenerator());
        try {
            ladderGameController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
