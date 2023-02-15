import config.LadderControllerFactory;
import controller.LadderController;

public class Application {

    public static void main(String[] args) {
        LadderController ladderController = LadderControllerFactory.generate();
        ladderController.run();
    }
}
