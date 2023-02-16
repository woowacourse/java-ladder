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
                    booleanGenerator(),
                    inputView(scanner),
                    outputView()
            );
            ladderGameController.run();
        }
    }

    private static RandomBooleanGenerator booleanGenerator() {
        return new RandomBooleanGenerator();
    }

    private static OutputView outputView() {
        return new OutputView();
    }

    private static InputView inputView(final Scanner scanner) {
        return new InputView(scanner);
    }
}
