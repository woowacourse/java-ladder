package utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    private static final String NOT_INTEGER_ERROR = "[ERROR] 입력값은 정수여야 합니다.";
    private static final String INSERT_BLANK_FORMAT = "%5s";
    private static final String BLANK = " ";
    private static final String EMPTY = "";
    private static final String SPLIT_DELIMITER = ",";
    private static final int SPLIT_LIMIT = -1;

    public static List<String> splitByDelimiter(final String input) {
        return Arrays.stream(input.split(SPLIT_DELIMITER, SPLIT_LIMIT))
                .map(name -> name.replace(BLANK, EMPTY))
                .collect(Collectors.toUnmodifiableList());
    }

    public static int parseToInteger(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_ERROR, e);
        }
    }

    public static String insertBlank(final String input) {
        return String.format(INSERT_BLANK_FORMAT, input);
    }
}
