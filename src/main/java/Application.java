import controller.RadderGameController;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
        RadderGameController radderGameController = new RadderGameController(inputView, outputView);
        radderGameController.play(randomBooleanGenerator);
    }
}
