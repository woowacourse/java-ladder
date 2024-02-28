import controller.LadderGame;
import controller.LadderGenerator;

public class Application {
    public static void main(String[] args) {
        LadderGenerator ladderDrawer = new LadderGenerator();
        ladderDrawer.generateLadder();

        LadderGame ladderGame = new LadderGame();
        ladderGame.climbLadder(ladderDrawer.getLadder());
    }
}
