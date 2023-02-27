import controller.LadderController;
import domain.booleangenerator.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(InputView.getInputView(), OutputView.getOutputView(), new RandomBooleanGenerator());
        ladderController.run();
    }
}
