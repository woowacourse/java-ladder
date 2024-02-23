package ladder;

import ladder.controller.LadderGame;
import ladder.manager.LadderGameManager;

public class Application {
    public static void main(String[] args) {
        LadderGameManager ladderGameManager = new LadderGameManager();
        LadderGame ladderGame = ladderGameManager.createLadderGame();
        ladderGame.run();
    }
}
