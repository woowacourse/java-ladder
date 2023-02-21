import controller.MainController;
import utils.BooleanGenerator;
import utils.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        MainController mainController = new MainController(inputView, outputView, booleanGenerator);

        mainController.start();
    }
}
