package laddergame.exception;

import java.util.function.Supplier;
import laddergame.view.OutputView;

public class ExceptionHandler {

    private static final int MAX_RETRY_COUNT = 1000;

    private static int retryCount = 0;

    public static <T> T retryBySupplier(final Supplier<T> function, final OutputView outputView) {
        try {
            return function.get();
        } catch (final IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            validateRetryCount();
            return retryBySupplier(function, outputView);
        }
    }

    private static void validateRetryCount() {
        if (retryCount++ >= MAX_RETRY_COUNT) {
            throw new IllegalArgumentException("[ERROR] 재시도 횟수를 초과했습니다.");
        }
    }

    public static void retryByRunnable(final Runnable runnable, final OutputView outputView) {
        try {
            runnable.run();
        } catch (final IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception.getMessage());
            validateRetryCount();
            retryByRunnable(runnable, outputView);
        }
    }
}
