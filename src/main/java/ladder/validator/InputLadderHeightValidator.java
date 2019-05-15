package ladder.validator;

import ladder.constant.MessageConstant;

import java.util.regex.Pattern;

public class InputLadderHeightValidator {

    public static void checkLadderHeightInputAccuracy(String input) {
        if (isHeightEmpty(input)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_HAS_VALUE_EMPTY);
        }
        if (!isIntegerNumber(input)) {
            throw new NumberFormatException(MessageConstant.ERROR_NOT_INTEGER);
        }
    }

    private static boolean isHeightEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean isIntegerNumber(String input) {
        return Pattern.matches("[1-9]\\d*|0", input);
    }
}
