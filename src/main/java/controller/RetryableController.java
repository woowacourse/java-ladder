package controller;

import common.exception.message.ExceptionMessage;
import common.exception.model.IOException;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class RetryableController {
    public static final int READ_LIMIT = 10;

    protected final InputView inputView;
    protected final OutputView outputView;
    private int retryCount;

    public RetryableController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.retryCount = 0;
    }

    protected <R> R retry(final Supplier<R> supplier) {
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

    protected void retryNoneReturn(final Runnable runnable) {
        validateRetryCountLimit();
        try {
            runnable.run();
            retryCount = 0;
        } catch (Exception exception) {
            outputView.printErrorMessage(exception.getMessage());
            retryNoneReturn(runnable);
        }
    }

    private void validateRetryCountLimit() {
        if (retryCount++ == READ_LIMIT) {
            throw new IOException(ExceptionMessage.READ_LIMIT_OVER);
        }
    }
}
