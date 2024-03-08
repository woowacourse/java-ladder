import controller.LadderGameController;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        List<String> prizes = Arrays.asList(new Scanner(System.in).nextLine().split(","));

        LadderGameController ladderGameController = new LadderGameController(new InputView(), new ResultView());
        ladderGameController.run();
    }
}
