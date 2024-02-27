import controller.LadderDrawer;
import controller.LadderGame;

public class Application {
    public static void main(String[] args) {
        LadderDrawer ladderDrawer = new LadderDrawer();
        ladderDrawer.generateLadder();

        LadderGame ladderGame = new LadderGame();
        ladderGame.climbLadder(ladderDrawer.getLadderComponents());
    }
}
