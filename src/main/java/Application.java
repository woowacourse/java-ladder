import controller.LadderController;
import domain.numbergenerator.RandomNumberGenerator;
import view.InputView;

public class Application {
    public static void main(String[] args) {
        LadderController ladderController = new LadderController(InputView.getInputView(), new RandomNumberGenerator());
        ladderController.run();
    }
}
