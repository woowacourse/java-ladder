import controller.LadderGameController;
import view.InputView;
import view.MessageResolver;
import view.ResultView;

public class Application {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(
                new InputView(), new InputMapper(), new ResultView(new MessageResolver()));
        ladderGameController.run();
    }
}
