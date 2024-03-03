package view;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    private static final String DELIMITER = ",";

    public static List<String> parseToStringList(String rawString) {
        if (rawString == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }

        return Arrays.stream(rawString.split(DELIMITER, -1))
            .map(String::trim)
            .toList();
    }

    public static int parseToInt(String rawString) {
        try {
            return Integer.parseInt(rawString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }
}
