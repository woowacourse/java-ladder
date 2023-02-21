package utils;

import static domain.ErrorMessages.NUMBER_FORMAT;
import static domain.GameRules.MAX_NAME_LENGTH;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    public static final String SPLIT_DELIMITER = ",";
    public static final int SPLIT_LIMIT = -1;

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
        return String.format("%" + MAX_NAME_LENGTH.getValue() + "s", input);
    }
}
