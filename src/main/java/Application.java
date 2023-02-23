import controller.Game;
import util.ConsoleMessagePrinter;
import util.RandomBooleanGenerator;
import util.ScannerInputReader;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(final String[] args) {
        Game game = new Game(
                new RandomBooleanGenerator(),
                new InputView(new ScannerInputReader()),
                new OutputView(new ConsoleMessagePrinter())
        );

        game.run();
    }
}
