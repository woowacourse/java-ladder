import controller.LadderController;
import view.InputView;
import view.OutputView;

public class Main {
    public static void main(String[] args) {
        new LadderController(new InputView(), new OutputView()).play();
    }
}
