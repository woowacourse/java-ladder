package handler;

import java.util.function.Supplier;

public class ExceptionHandler {

    public <T> T handleInputException(Supplier<T> recursiveCallback) {
        try {
            return recursiveCallback.get();
        } catch (Exception e) {
            System.out.printf("%n[ERROR] %s%n", e.getMessage());
            return handleInputException(recursiveCallback);
        }
    }
}
