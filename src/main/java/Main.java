import controller.LadderGame;
import generator.RandomBooleanGenerator;

public class Main {
    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new RandomBooleanGenerator());
        ladderGame.run();
    }
}
