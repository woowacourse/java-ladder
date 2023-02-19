import controller.LadderGameController;
import util.ConsoleMessagePrinter;
import util.RandomBooleanGenerator;
import util.ScannerInputReader;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(final String[] args) {
        LadderGameController game = new LadderGameController(
                new RandomBooleanGenerator(),
                new InputView(new ScannerInputReader()),
                new OutputView(new ConsoleMessagePrinter())
        );

        game.run();
    }
}
