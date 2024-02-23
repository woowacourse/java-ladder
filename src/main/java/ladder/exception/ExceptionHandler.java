package ladder.exception;

import ladder.view.OutputView;

import java.util.Optional;
import java.util.function.Supplier;

public class ExceptionHandler {
    private final OutputView outputView;

    public ExceptionHandler(final OutputView outputView) {
        this.outputView = outputView;
    }

    public  <T> T retryOnException(final Supplier<T> retryOperation) {
        boolean retry = true;
        Optional<T> result = Optional.empty();
        while (retry) {
            result = tryOperation(retryOperation);
            retry = result.isEmpty();
        }
        return result.get();
    }

    private <T> Optional<T> tryOperation(final Supplier<T> operation) {
        try {
            return Optional.of(operation.get());
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return Optional.empty();
        }
    }
}
