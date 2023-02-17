import controller.LadderGameController;
import domain.RandomPointGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomPointGenerator generator = new RandomPointGenerator();
        LadderGameController controller = new LadderGameController(inputView, outputView, generator);

        controller.run();
    }
}
