import controller.LadderGame;
import util.RandomLadderItemGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomLadderItemGenerator randomBooleanGenerator = new RandomLadderItemGenerator();
        LadderGame ladderGame = new LadderGame(inputView, outputView, randomBooleanGenerator);

        ladderGame.start();
    }
}
