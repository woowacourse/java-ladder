import controller.LadderGameController;
import util.RandomTrueOrFalseGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        LadderGameController ladderGameController =
                new LadderGameController(new InputView(), new OutputView(), new RandomTrueOrFalseGenerator());
        ladderGameController.run();
    }
}
