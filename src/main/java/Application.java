import controller.LadderController;
import domain.numbergenerator.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new RandomNumberGenerator());
        ladderController.run();
    }
}
