package ladder.config;

import ladder.controller.LadderController;
import ladder.domain.ladder.generator.BooleanGenerator;
import ladder.domain.ladder.generator.RandomBooleanGenerator;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.console.ConsoleInputView;
import ladder.view.console.ConsoleOutputView;

public class AppConfig {
    private AppConfig() {
    }

    public static InputView consoleInputView() {
        return new ConsoleInputView();
    }

    public static OutputView consoleOutputView() {
        return new ConsoleOutputView();
    }

    public static BooleanGenerator randomBooleanGenerator() {
        return new RandomBooleanGenerator();
    }

    public static LadderController ladderController() {
        return new LadderController(
                consoleInputView(),
                consoleOutputView(),
                randomBooleanGenerator()
        );
    }
}
