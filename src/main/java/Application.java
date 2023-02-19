import application.LadderGameApplication;
import domain.LadderGenerator;
import domain.LineGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderGameApplication ladderGameApp = new LadderGameApplication(
                new InputView(), new OutputView(),
                initLadderGenerator());
        ladderGameApp.run();
    }

    private static LadderGenerator initLadderGenerator() {
        return new LadderGenerator(new LineGenerator(new RandomNumberGenerator()));
    }
}
