package ladder.controller;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class IllegalArgumentExceptionHandler {

    private IllegalArgumentExceptionHandler() {

    }

    public static <T, R> R repeatUntilNoException(final Supplier<T> supplier,
                                                  final Function<T, R> function,
                                                  final Consumer<String> consumer) {
        R output = null;

        while (output == null) {
            output = createOutputOrNull(supplier, function, consumer);
        }
        return output;
    }

    public static <T, R> R createOutputOrNull(final Supplier<T> inputSupplier,
                                              final Function<T, R> function,
                                              final Consumer<String> consumer) {
        try {
            final T input = inputSupplier.get();
            return function.apply(input);

        } catch (final IllegalArgumentException e) {
            consumer.accept(e.getMessage());
            return null;
        }
    }

}
