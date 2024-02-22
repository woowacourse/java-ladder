package ladder.util;

import java.util.Optional;
import java.util.function.Supplier;

public class ExceptionRetryHandler {
    private ExceptionRetryHandler() {
    }

    public static <T> T handle(Supplier<T> supplier) {
        Optional<T> result = Optional.empty();
        while (result.isEmpty()) {
            result = tryGet(supplier);
        }

        return result.get();
    }

    private static <T> Optional<T> tryGet(Supplier<T> supplier) {
        try {
            return Optional.of(supplier.get());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }
}
