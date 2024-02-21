import controller.LadderController;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView());
        ladderController.run();
    }
}
