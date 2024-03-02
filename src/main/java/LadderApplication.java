import game.LadderGame;
import java.util.Random;
import view.InputView;
import view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Random random = new Random();

        LadderGame ladderGame = new LadderGame(inputView, outputView, random::nextBoolean);
        ladderGame.play();
    }
}
