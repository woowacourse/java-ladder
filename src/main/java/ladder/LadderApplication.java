package ladder;

import java.util.Scanner;
import ladder.controller.LadderController;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        final InputView inputView = new InputView(new Scanner(System.in));
        final OutputView outputView = new OutputView();

        final LadderController ladderController = new LadderController(inputView, outputView);
        ladderController.run();
    }
}
