import controller.LadderGameController;
import util.RandomBooleanGenerator;
import util.ScannerInputReader;
import view.InputView;

public class Application {
    public static void main(final String[] args) {
        LadderGameController game = new LadderGameController(
                new RandomBooleanGenerator(),
                new InputView(new ScannerInputReader())
        );
        game.run();
    }
}
