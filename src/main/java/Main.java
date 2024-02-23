import controller.LadderGame;
import domain.ladder.RandomLadderRungGenerator;

public class Main {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new RandomLadderRungGenerator());
        ladderGame.run();
    }
}
