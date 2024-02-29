import controller.LadderGameController;
import domain.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class Main {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController(new InputView(), new OutputView(),
                new RandomBooleanGenerator());

        ladderGameController.run();
    }
}
