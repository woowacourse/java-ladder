import controller.LadderController;
import domain.numbergenerator.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(InputView.getInputView(), OutputView.getOutputView(), new RandomNumberGenerator());
        ladderController.run();
    }
}
