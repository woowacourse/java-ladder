import application.LadderGameApplication;
import domain.LadderGenerator;
import utils.RandomNumberGenerator;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderGameApplication ladderGameApp = new LadderGameApplication(
                new InputView(), new OutputView(),
                new LadderGenerator(new RandomNumberGenerator()));
        ladderGameApp.run();
    }
}
