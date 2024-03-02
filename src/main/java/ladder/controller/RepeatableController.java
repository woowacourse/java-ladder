package ladder.controller;

import java.util.function.Supplier;
import ladder.view.OutputView;

public class RepeatableController {

    protected final OutputView outputView;

    public RepeatableController(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T repeatUntilValid(Supplier<T> function) {
        try {
            return function.get();
        } catch (IllegalArgumentException e) {
            outputView.printError(e);
            return repeatUntilValid(function);
        }
    }
}
