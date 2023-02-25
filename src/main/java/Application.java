import LadderGame.LadderGame;
import domain.BooleanCreatorImplements;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderGame ladderGame = new LadderGame(new BooleanCreatorImplements());
        ladderGame.start();
    }
}
