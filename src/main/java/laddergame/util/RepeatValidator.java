package laddergame.util;

import laddergame.view.OutputView;

public class RepeatValidator {

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
