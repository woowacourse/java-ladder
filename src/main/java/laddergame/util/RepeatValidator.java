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
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public static void runUntilValidate(InputFunction inputFunction) {
        boolean isSuccess = false;
        while (!isSuccess) {
            isSuccess = tryInputFunction(inputFunction);
        }
    }

    private static boolean tryInputFunction(InputFunction inputFunction) {
        try {
            inputFunction.run();
            return true;
        } catch (RuntimeException exception) {
            OutputView.printErrorMsg(exception.getMessage());
            return false;
        }
    }
}
