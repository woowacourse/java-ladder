import controller.LadderController;
import domain.booleanGenerator.RandomBooleanGenerator;

public class Main {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new RandomBooleanGenerator());
        ladderController.run();
    }
}
