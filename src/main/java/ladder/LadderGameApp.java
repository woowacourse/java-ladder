package ladder;

import ladder.controller.LadderGame;

public class LadderGameApp {
    public static void main(String[] args) {
        LadderGame ladderGame = createLadderGame();
        ladderGame.play();
    }

    private static LadderGame createLadderGame() {
        try {
            return new LadderGame();
        }
        catch (Exception e){
                System.out.println(e.getMessage());
            return createLadderGame();
        }
    }
}
