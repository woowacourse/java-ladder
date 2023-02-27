package util;

import view.OutputView;

import java.util.function.Supplier;

public interface Task {

    static <T> T retryUntilSuccess(Supplier<T> supplier, OutputView outputView) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception);
            }
        }
    }
}
