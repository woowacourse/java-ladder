package laddergame;

import laddergame.controller.LadderGame;
import laddergame.domain.Ladder;

public class LadderGameLauncher {
    public static void main(String[] args) {
        doLadderGame();
    }

    private static void doLadderGame() {
        LadderGame game = new LadderGame();
        game.play();

        /*Ladder ladder = new Ladder(4,5);
        System.out.println(ladder);*/

        /*System.out.println("%-5d%n", "|");
        System.out.println("%-5d%n", "----|");*/
    }
}
