package ladder;

import ladder.controller.FrontExceptionController;
import ladder.controller.LadderGameController;
import ladder.view.InputView;
import ladder.view.OutputView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        new LadderGameController(
                new InputView(new Scanner(System.in)),
                new OutputView(),
                new FrontExceptionController(new OutputView())
        ).run();
    }
}
