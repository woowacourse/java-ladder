package ladder;

import java.util.Scanner;
import ladder.controller.LadderController;
import ladder.domain.Retry;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        final InputView inputView = new InputView(new Scanner(System.in));
        final OutputView outputView = new OutputView();
        final Retry retry = new Retry();

        final LadderController ladderController = new LadderController(inputView, outputView, retry);
        ladderController.run();
    }
}
