package common.exception.handler;

import java.util.function.Supplier;

import view.OutputView;

public class IllegalArgumentExceptionHandler {

    public static <T> T handleExceptionByRepeating(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            OutputView.printException(exception);
            return handleExceptionByRepeating(supplier);
        }
    }
}
