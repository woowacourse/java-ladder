package ladder;

import ladder.controller.LadderGameController;

public class Application {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.play();
    }
}
