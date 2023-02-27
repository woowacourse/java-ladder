package laddergame;

import laddergame.controller.LadderGameController;

public class Application {

    public static void main(String[] args) {
        LadderGameController controller = new LadderGameController();
        controller.run();
    }
}
