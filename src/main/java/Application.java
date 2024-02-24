import Controller.LadderGame;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LadderGame ladderGame = new LadderGame(inputView, outputView);
        ladderGame.run();
    }
}
