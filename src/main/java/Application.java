import controller.LadderGame;
import view.InputView;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        LadderGame ladderGame = new LadderGame(inputView);

        ladderGame.start();
    }
}
