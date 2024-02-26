import controller.LadderGame;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            final LadderGame ladderGame = new LadderGame(new InputView(), new OutputView());
            ladderGame.play();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
