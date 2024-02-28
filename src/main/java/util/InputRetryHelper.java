package util;

import java.util.function.Supplier;

public class InputRetryHelper {
    private InputRetryHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static <T> T inputRetryHelper(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
