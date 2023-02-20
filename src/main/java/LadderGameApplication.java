import controller.LadderGameController;
import domain.ladder.strategy.RandomGenerateBridgeStrategy;

public class LadderGameApplication {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new RandomGenerateBridgeStrategy());

        try {
            ladderGameController.run();
        } catch (Exception exception) {
            ladderGameController.printError(exception);
        }
    }

}
