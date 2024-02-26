import Controller.LadderController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(InputView.of(), OutputView.from());
        ladderController.run();
    }
}
