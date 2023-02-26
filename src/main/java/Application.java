import controller.LadderGameController;
import domain.BooleanGeneratorImplements;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new InputView(), new OutputView(), new BooleanGeneratorImplements());
        ladderGameController.run();
    }
}
