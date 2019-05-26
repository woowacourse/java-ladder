package laddergame;

import laddergame.controller.LadderGame;

public class LadderGameLauncher {
    public static void main(String[] args) {
        doLadderGame();
    }

    private static void doLadderGame() {
        LadderGame game = new LadderGame();
        game.play();
    }
}
