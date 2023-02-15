import controller.LadderController;
import utils.NumberGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderController ladderController = new LadderController(new InputView(), new OutputView(),
                initNumberGenerator());
        ladderController.run();
    }

    private static NumberGenerator initNumberGenerator() {
        return new RandomNumberGenerator();
    }
}
