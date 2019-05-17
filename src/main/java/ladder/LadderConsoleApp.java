package ladder;

import ladder.controller.LadderGameController;

public class LadderConsoleApp {
    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.run();
    }
}
