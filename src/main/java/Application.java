import controller.Controller;
import domain.LadderGenerator;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller(new InputView(),new OutputView(), new LadderGenerator());
        controller.run();
    }
}
