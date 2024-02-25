package ladder.utils;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class InputUtility {
    public static <T> T retryUntilGet(Supplier<T> supplier) {
        Optional<T> result = Optional.empty();

        while (result.isEmpty()) {
            result = Optional.ofNullable(supplier.get());
        }
        return result.get();
    }

    public static <T,R> R retryUntilGet(Function<T,R> function, T input) {
        Optional<R> result = Optional.empty();

        while (result.isEmpty()) {
            result = Optional.ofNullable(function.apply(input));
        }
        return result.get();
    }
}
