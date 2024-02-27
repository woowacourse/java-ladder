package ladder.utils;

import java.util.function.Supplier;

public class InputUtility {
    public static <T> T retryWhileThrowArgumentException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return retryWhileThrowArgumentException(supplier);
        }
    }
}
