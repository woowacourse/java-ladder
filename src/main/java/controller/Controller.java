package controller;

import common.exception.message.ExceptionMessage;
import common.exception.model.IOException;
import view.InputView;
import view.OutputView;

import java.util.function.Supplier;

public class Controller {
    protected final InputView inputView;
    protected final OutputView outputView;

    protected static final int INIT_RETRY_COUNT = 0;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public <R> R retry(final Supplier<R> supplier, final int retryCount) {
        if (retryCount == InputView.READ_LIMIT) {
            throw new IOException(ExceptionMessage.READ_LIMIT_OVER);
        }
        try {
            return supplier.get();
        } catch (Exception exception) {
            outputView.printErrorMessage(exception);
            return retry(supplier, retryCount + 1);
        }
    }
}
