package util;

import java.util.function.Supplier;

public class RetryHelper {
    private RetryHelper() {
    }

    public static <T> T retryHelper(Supplier<T> supplier, String userPrompt) {
        while (true) {
            try {
                System.out.println(userPrompt);
                return supplier.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
