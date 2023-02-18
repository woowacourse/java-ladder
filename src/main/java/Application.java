import controller.LadderGameController;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        LadderGameController ladderGameController = new LadderGameController( new InputView(new Scanner(System.in)),new OutputView());
        ladderGameController.run();
    }
}
