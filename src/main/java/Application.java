import controller.Controller;
import view.InputView;
import view.OutputView;
import view.ResultView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView(), new ResultView());
        controller.run();
    }
}
