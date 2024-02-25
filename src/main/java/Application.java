import Controller.LadderGame;
 import view.InputView;
import view.OutputView;
import view.printer.Printer;
import view.reader.Reader;

public class Application {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Reader reader = new Reader();
        LadderGame ladderGame = new LadderGame(InputView.of(reader, printer), OutputView.from(printer));
        ladderGame.run();
    }
}
