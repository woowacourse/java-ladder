package controller;

import common.exception.message.ExceptionMessage;
import java.util.function.Supplier;
import view.InputView;
import view.OutputView;

public class Controller {
    protected final InputView inputView;
    protected final OutputView outputView;
    private int retryCount;

    public static final int READ_LIMIT = 10;

    public Controller(final InputView inputView, final OutputView outputView) {
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
            throw new IllegalArgumentException(ExceptionMessage.READ_LIMIT_OVER);
        }
    }
}
