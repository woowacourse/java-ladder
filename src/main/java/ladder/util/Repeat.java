package ladder.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Repeat {

    private Repeat() {
    }

    public static <T> T repeat(Supplier<T> supplier, Consumer<Exception> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            exceptionHandler.accept(e);
            return repeat(supplier, exceptionHandler);
        }
    }
}
