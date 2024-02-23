import controller.LadderGame;
import util.RandomBooleanGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomBooleanGenerator randomBooleanGenerator = new RandomBooleanGenerator();
        LadderGame ladderGame = new LadderGame(inputView, outputView, randomBooleanGenerator);

        ladderGame.start();
    }
}
