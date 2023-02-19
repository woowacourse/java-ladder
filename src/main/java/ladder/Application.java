package ladder;

import ladder.controller.LadderGameController;

public class Application {

    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController();
        controller.run();
    }
}
