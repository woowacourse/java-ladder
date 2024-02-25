import controller.LadderGame;
import util.RandomLineItemGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        RandomLineItemGenerator randomBooleanGenerator = new RandomLineItemGenerator();
        LadderGame ladderGame = new LadderGame(inputView, outputView, randomBooleanGenerator);

        ladderGame.start();
    }
}
