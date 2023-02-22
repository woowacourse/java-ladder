import controller.LadderGameController;
import util.RandomBooleanGenerator;
import view.input.InputView;
import view.output.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
        LadderGameController ladderGameController = new LadderGameController();
        ladderGameController.play(inputView, outputView, randomBooleanGenerator);
    }
}
