package ladder;

import ladder.controller.LadderGameManager;

public class LadderGameApplication {
    public static void main(String[] args) {
        LadderGameManager ladderGameManager = new LadderGameManager();
        ladderGameManager.start();
    }
}
