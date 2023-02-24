import controller.LadderGameController;
import domain.LadderGame;
import domain.ladder.strategy.GenerateBridgeStrategy;
import domain.ladder.strategy.RandomGenerateBridgeStrategy;
import view.InputView;
import view.OutputView;

public class LadderGameApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        GenerateBridgeStrategy randomBridgeStrategy = new RandomGenerateBridgeStrategy();
        LadderGameController ladderGameController = new LadderGameController(inputView, outputView,
                randomBridgeStrategy);

        try {
            LadderGame ladderGame = ladderGameController.initGame();
            ladderGameController.run(ladderGame);
        } catch (Exception exception) {
            ladderGameController.printError(exception);
        }
    }

}
