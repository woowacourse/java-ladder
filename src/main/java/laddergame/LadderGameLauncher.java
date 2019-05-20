package laddergame;

import laddergame.controller.LadderGame;
import laddergame.domain.Players;

public class LadderGameLauncher {
    public static void main(String[] args) {
        doLadderGame();
    }

    private static void doLadderGame() {
        //LadderGame game = new LadderGame();
        //game.play();
        Players players = LadderGame.generatePlayers();

    }
}
