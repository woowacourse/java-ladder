import controller.LadderGameController;
import view.InputView;
import view.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        LadderGameController ladderGameController = new LadderGameController(new InputView(scanner), new OutputView());
        ladderGameController.play();
        scanner.close();
    }
}
