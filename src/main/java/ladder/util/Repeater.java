package ladder.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Repeater {

    private Repeater() {
    }

    public static <T> T repeatIfError(Supplier<T> supplier, Consumer<Exception> exceptionHandler) {
        try {
            return supplier.get();
        } catch (Exception e) {
            exceptionHandler.accept(e);
            return repeatIfError(supplier, exceptionHandler);
        }
    }
}
