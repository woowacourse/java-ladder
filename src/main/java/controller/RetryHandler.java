package controller;

import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class RetryHandler {
    public static final int READ_LIMIT = 10;

    private final InputView inputView;
    private final OutputView outputView;
    private int retryCount;

    public RetryHandler(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryCount = 0;
    }

    public <R> R retry(final Supplier<R> supplier) {
        validateRetryCountLimit();
        try {
            R value = supplier.get();
            retryCount = 0;
            return value;
        } catch (Exception exception) {
            outputView.printErrorMessage(exception.getMessage());
            return retry(supplier);
        }
    }

    private void validateRetryCountLimit() {
        if (retryCount++ == READ_LIMIT) {
            throw new IllegalArgumentException(InputView.READ_LIMIT_OVER);
        }
    }
}
