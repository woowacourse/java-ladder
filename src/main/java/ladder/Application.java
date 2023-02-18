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
                    getBooleanGenerator(),
                    getInputView(scanner),
                    getOutputView()
            );
            ladderGameController.run();
        }
    }

    private static RandomBooleanGenerator getBooleanGenerator() {
        return new RandomBooleanGenerator();
    }

    private static OutputView getOutputView() {
        return new OutputView();
    }

    private static InputView getInputView(final Scanner scanner) {
        return new InputView(scanner);
    }
}
