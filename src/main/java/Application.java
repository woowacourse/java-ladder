import controller.LadderController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        final LadderController ladderController = new LadderController(InputView.create(), OutputView.create());
        ladderController.run();
    }
}
