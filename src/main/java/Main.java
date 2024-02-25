import controller.LadderController;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) throws Exception {
        try (InputView inputView = new InputView();
             OutputView outputView = new OutputView()) {
            new LadderController(inputView, outputView).play();
        }
    }
}
