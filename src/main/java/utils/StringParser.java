package utils;

import static utils.constants.ErrorMessages.NUMBER_FORMAT;
import static utils.constants.GameRules.MAX_NAME_LENGTH;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    public static final String SPLIT_DELIMITER = ",";
    public static final int SPLIT_LIMIT = -1;
    public static final int ZERO = 0;

    public static List<String> splitByDelimiter(String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER, SPLIT_LIMIT))
                .map(name -> name.replace(" ", ""))
                .collect(Collectors.toUnmodifiableList());
    }

    public static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NUMBER_FORMAT.getMessage(), exception);
        }
    }

    public static String insertBlank(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ".repeat(Math.max(ZERO, MAX_NAME_LENGTH.getValue()) - input.length()));
        stringBuilder.append(input);
        return stringBuilder.toString();
    }
}
