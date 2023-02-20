package ladder;

import java.util.Scanner;
import ladder.controller.LadderGameController;
import ladder.domain.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;

public class Application {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            final LadderGameController ladderGameController = new LadderGameController(
                    new RandomBooleanGenerator(),
                    new InputView(scanner),
                    new OutputView()
            );
            ladderGameController.run();
        }
    }
}
