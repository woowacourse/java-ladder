package ladder.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Repeater {

    private Repeater() {
    }

    public static <T> T repeatIfError(Supplier<T> operation, Consumer<Exception> handler) {
        boolean shouldRepeat = true;
        T result = null;
        while (shouldRepeat) {
            try {
                result = operation.get();
                shouldRepeat = false;
            } catch (Exception e) {
                handler.accept(e);
            }
        }
        return result;
    }
}
