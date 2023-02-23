package ladder;

import ladder.domain.controller.LadderGameController;

public class MainApplication {

    public static void main(String[] args) {
        var ladderGameController = new LadderGameController();
        ladderGameController.run();
    }
}

