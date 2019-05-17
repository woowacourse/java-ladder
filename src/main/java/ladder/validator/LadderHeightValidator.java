package ladder.validator;

import ladder.constant.MessageConstant;

import java.util.regex.Pattern;

public class LadderHeightValidator {
    private LadderHeightValidator() {
    }

    public static final int MIN_HEIGHT = 1;

    public static void checkAccuracyOfUserInput(String input) {
        if (isHeightEmpty(input)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EMPTY_VALUE);
        }
        if (!isIntegerNumber(input.trim())) {
            throw new NumberFormatException(MessageConstant.ERROR_NOT_INTEGER);
        }
        if (Integer.parseInt(input.trim()) < MIN_HEIGHT) {
            throw new IllegalArgumentException(MessageConstant.ERROR_BELOW_HEIGHT);
        }
    }

    private static boolean isHeightEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean isIntegerNumber(String input) {
        return Pattern.matches("-?[1-9]\\d*|0", input);
    }
}
