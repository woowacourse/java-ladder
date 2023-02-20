package laddergame;

import laddergame.controller.LadderGameController;

public class Application {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.run();
    }
}
