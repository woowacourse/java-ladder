import controller.Controller;
import domain.BooleanGeneratorImplements;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView(), new BooleanGeneratorImplements());
        controller.run();
    }
}
