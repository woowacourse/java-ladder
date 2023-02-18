import application.LadderGameApplication;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        LadderGameApplication ladderGameApp = new LadderGameApplication(new InputView(), new OutputView());
        ladderGameApp.run();
    }
}
