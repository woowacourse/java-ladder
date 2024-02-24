package domain;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public static List<String> splitByDelimiter(String before, String delimiter) {
        try {
            return Arrays.stream(before.split(delimiter, -1))
                    .map(String::trim)
                    .toList();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
    }

    public static int stringToInt(String before) {
        try {
            return Integer.parseInt(before);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
