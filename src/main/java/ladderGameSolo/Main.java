package ladderGameSolo;

import ladderGameSolo.controller.LadderGame;
import ladderGameSolo.view.GameView;

public class Main {
    public static void main(String[] args) {
        GameView gameView = new GameView();
        LadderGame ladderGame = new LadderGame(gameView);

        ladderGame.run();
    }
}
