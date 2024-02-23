import controller.LadderGameController;
import view.ExceptionHandler;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ExceptionHandler exceptionHandler = new ExceptionHandler(outputView);
        LadderGameController ladderGameController = new LadderGameController(inputView, outputView, exceptionHandler);
        ladderGameController.run();
    }
}
