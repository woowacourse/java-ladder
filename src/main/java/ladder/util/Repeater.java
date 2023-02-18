package ladder.util;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Repeater {

    private Repeater() {
    }

    public static <T> T repeatIfError(Supplier<T> operation, Consumer<Exception> handler) {
        Result<T> result = new Result<>();
        while (result.shouldRepeat) {
            result = getResult(operation, handler, result);
        }
        return result.result;
    }

    private static <T> Result<T> getResult(Supplier<T> operation, Consumer<Exception> handler, Result<T> result) {
        try {
            result = new Result<>(operation.get());
        } catch (Exception e) {
            handler.accept(e);
        }
        return result;
    }

    private static class Result<T> {

        private final T result;
        private final boolean shouldRepeat;

        private Result() {
            shouldRepeat = true;
            result = null;
        }

        private Result(T result) {
            shouldRepeat = false;
            this.result = result;
        }
    }
}
