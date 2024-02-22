package ladder.util;

import ladder.view.OutputView;

import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T run(Supplier<T> callback) {
        try {
            return callback.get();
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return run(callback);
        }
    }
}
