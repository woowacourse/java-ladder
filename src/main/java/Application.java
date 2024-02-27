import controller.LadderController;
import view.InputView;
import view.OutputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView(), new OutputView(), new ResultView());
        ladderController.run();
    }
}
