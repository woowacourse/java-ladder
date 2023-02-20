package ladder;

import java.util.Scanner;
import ladder.controller.LadderController;
import ladder.domain.generator.LadderGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class LadderApplication {

    public static void main(String[] args) {
        final var inputView = new InputView(new Scanner(System.in));
        final var outputView = new OutputView();
        final var ladderGenerator = new LadderGenerator();

        LadderController ladderController = new LadderController(inputView, outputView, ladderGenerator);
        ladderController.run();
    }
}
