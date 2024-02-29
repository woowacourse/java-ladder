package ladder;

import ladder.controller.LadderController;
import ladder.view.InputView;
import ladder.view.OutputView;
import ladder.view.validator.InputValidator;

public class AppConfig {

    private AppConfig() {
    }

    public static InputView inputView() {
        return new InputView(inputValidator());
    }

    private static InputValidator inputValidator() {
        return new InputValidator();
    }

    public static OutputView outputView() {
        return new OutputView();
    }

    public static LadderController ladderController() {
        return new LadderController(inputView(), outputView());
    }
}
