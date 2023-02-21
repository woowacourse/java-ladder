import controller.Controller;
import domain.BooleanCreatorImplements;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(), new OutputView(), new BooleanCreatorImplements());
        controller.run();
    }
}
