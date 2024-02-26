package ladder;

import ladder.controller.LadderGameController;
import ladder.service.LadderGameService;

public class Main {
    public static void main(String[] args) {
        LadderGameController  ladderGameController =
                new LadderGameController(new LadderGameService());
        ladderGameController.run();
    }
}
