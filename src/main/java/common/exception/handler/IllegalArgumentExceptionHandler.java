package common.exception.handler;

import java.util.function.Supplier;

public class IllegalArgumentExceptionHandler {

    public static <T> T handleExceptionByRepeating(final Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return handleExceptionByRepeating(supplier);
        }
    }
}
