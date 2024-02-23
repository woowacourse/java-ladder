package view;

import java.util.function.Supplier;

public class ExceptionHandler {
    private final OutputView outputView;

    public ExceptionHandler(OutputView outputView) {
        this.outputView = outputView;
    }

    public <T> T retryUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
