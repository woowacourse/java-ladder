import game.LadderGame;
import generator.BooleanGenerator;
import generator.LadderBooleanGenerator;
import java.util.Random;
import view.ConsoleReader;
import view.InputView;
import view.OutputView;

public class LadderMain {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader(System.in);
        InputView inputView = new InputView(consoleReader);
        OutputView outputView = new OutputView();
        Random random = new Random();
        BooleanGenerator generator = new LadderBooleanGenerator(random::nextBoolean);

        LadderGame ladderGame = new LadderGame(inputView, outputView, generator);
        ladderGame.play();
    }
}
