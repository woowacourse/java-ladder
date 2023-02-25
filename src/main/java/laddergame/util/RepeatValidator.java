package laddergame.util;

import laddergame.view.OutputView;

import java.util.function.Supplier;

public class RepeatValidator {

    public static <T> T readUntilValidate(Supplier<T> expression) {
        T input = null;
        do {
            input = trySupplier(expression);
        } while (input == null);

        return input;
    }

    private static <T> T trySupplier(Supplier<T> expression) {
        try {
            return expression.get();
        } catch (RuntimeException exception) {
            OutputView.printErrorMsg(exception);
            return null;
        }
    }

}
