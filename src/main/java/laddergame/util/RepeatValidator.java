package laddergame.util;

import laddergame.view.OutputView;

import java.util.function.Supplier;

public class RepeatValidator {

    public static <T> T retryUntilValidate(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException exception) {
            OutputView.printErrorMsg(exception.getMessage());
            return retryUntilValidate(supplier);
        }
    }
}
