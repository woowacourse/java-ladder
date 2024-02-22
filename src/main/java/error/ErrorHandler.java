package error;

import java.util.function.Supplier;

public class ErrorHandler {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public <T> T readUntilNoError(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREFIX + e.getMessage());
            return readUntilNoError(supplier);
        }
    }
}
