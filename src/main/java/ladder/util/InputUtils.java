package ladder.util;

import java.util.Arrays;
import java.util.List;
import ladder.exception.ErrorMessage;
import ladder.exception.InvalidInputException;

public class InputUtils {
    private static final String DELIMITER = ",";

    private InputUtils() {
    }

    public static int parseToInt(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(ErrorMessage.INPUT_NOT_A_NUMBER);
        }
    }

    public static List<String> splitByComma(final String input) {
        String[] parts = input.split(DELIMITER, -1);

        return Arrays.stream(parts)
                .map(String::strip)
                .toList();
    }
}
