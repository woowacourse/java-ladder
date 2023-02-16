package ladder;

import ladder.controller.LadderGameController;
import ladder.utils.RandomLineStrategy;

public class Application {
    public static void main(String[] args) {
        LadderGameController gameController = new LadderGameController();
        gameController.run(new RandomLineStrategy());
    }
}
