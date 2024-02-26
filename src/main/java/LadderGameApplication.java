import controller.LadderController;
import controller.RetryHandler;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class LadderGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        OutputView outputView = new OutputView();
        RetryHandler retryHandler = initHandler(inputView, outputView);
        LadderController ladderController = new LadderController(inputView, outputView, retryHandler);

        ladderController.createLadder();
    }

    private static RetryHandler initHandler(InputView inputView, OutputView outputView) {
        return new RetryHandler(inputView, outputView);
    }
}
