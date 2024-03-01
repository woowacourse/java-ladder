package ladder.view.exception;

import java.util.function.Supplier;

public class ExceptionHandler {
    public <T> T run(final Supplier<T> callback) {
        try {
            return callback.get();
        } catch (IllegalArgumentException exception) {
            System.out.printf("%n[ERROR] %s%n", exception.getMessage());
            return run(callback);
        }
    }
}
