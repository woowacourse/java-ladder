package controller;

import java.util.function.Supplier;

public class ExceptionHandler {

    public <T> T handleWithRetry(Supplier<T> recursiveCallback) {
        try {
            return recursiveCallback.get();
        } catch (Exception e) {
            System.out.printf("%n[ERROR] %s%n", e.getMessage());
            return handleWithRetry(recursiveCallback);
        }
    }

    public void handleWithRetry(Runnable recursiveCallback) {
        try {
            recursiveCallback.run();
        } catch (Exception e) {
            System.out.printf("%n[ERROR] %s%n", e.getMessage());
            handleWithRetry(recursiveCallback);
        }
    }
}
