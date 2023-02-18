import controller.LadderGameController;
import util.RandomBooleanGenerator;

public class Application {
    public static void main(final String[] args) {
        LadderGameController game = new LadderGameController(new RandomBooleanGenerator());
        game.run();
    }
}
