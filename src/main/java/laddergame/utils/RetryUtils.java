package laddergame.utils;

import java.util.function.Supplier;

public class RetryUtils {

    private RetryUtils() {
    }

    // TODO: while문의 count를 적용
    public static <T> T retryOnRuntimeException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException ignored) {
                /* IGNORED */
            }
        }
    }

    public static <T> T retryOnRuntimeExceptionWithMessage(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
