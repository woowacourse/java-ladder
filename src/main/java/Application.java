import Controller.Controller;
import domain.InputView;
import domain.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();
        Controller controller = new Controller(inputView, outputView);
        controller.run();
    }
}
