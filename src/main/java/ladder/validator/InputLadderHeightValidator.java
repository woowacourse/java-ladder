package ladder.validator;

import ladder.MessageCollection;

import java.util.regex.Pattern;

public class InputLadderHeightValidator {

    public static final int MIN_HEIGHT = 1;

    public static void checkLadderHeightInputAccuracy(String input) {
        if (isHeightEmpty(input)) {
            throw new IllegalArgumentException(MessageCollection.ERROR_HAS_VALUE_EMPTY);
        }
        if (!isIntegerNumber(input.trim())) {
            throw new NumberFormatException(MessageCollection.ERROR_NOT_INTEGER);
        }
        if (Integer.parseInt(input.trim()) < MIN_HEIGHT) {
            throw new IllegalArgumentException(MessageCollection.ERROR_LOWER_MIN_HEIGHT);
        }
    }

    private static boolean isHeightEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private static boolean isIntegerNumber(String input) {
        return Pattern.matches("-?[1-9]\\d*|0", input);
    }
}
