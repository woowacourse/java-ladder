import ladder.LadderGameRunner;
import ladder.view.InputView;
import ladder.view.ResultView;
import ladder.view.exception.ExceptionHandler;

public class Application {
    public static void main(String[] args) {
        LadderGameRunner ladderGameRunner = new LadderGameRunner(
                new InputView(new ExceptionHandler()),
                new ResultView()
        );
        ladderGameRunner.run();
    }
}
