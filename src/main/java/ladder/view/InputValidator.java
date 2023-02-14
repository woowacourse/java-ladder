package ladder.view;

import ladder.constant.ErrorConstant;

public class InputValidator {

    private static final String INPUT_IS_NOT_INTEGER = "입력된 값은 정수가 아닙니다.";

    public static void validateInteger(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorConstant.ERROR_PREFIX + INPUT_IS_NOT_INTEGER);
        }
    }
}
