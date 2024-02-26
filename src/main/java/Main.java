import controller.GameController;
import error.ErrorHandler;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ErrorHandler errorHandler = new ErrorHandler();

        GameController gameController = new GameController(inputView, outputView, errorHandler);
        gameController.run();
    }
}
