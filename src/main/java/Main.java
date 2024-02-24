import controller.GameController;
import error.ErrorHandler;
import strategy.RandomPointStrategy;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        GameController gameController = new GameController(
            new InputView(), new OutputView(), new ErrorHandler(), new RandomPointStrategy());

        gameController.start();
    }
}
