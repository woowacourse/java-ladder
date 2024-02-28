package util;

import java.util.function.Supplier;

public class RetryHelper {
    private RetryHelper() {
    }

    public static <T> T retryHelper(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
