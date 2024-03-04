package ladder.util;

import java.util.function.Supplier;

public class RetryHandler {

    public static <T> T run(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return run(supplier);
        }
    }
}
