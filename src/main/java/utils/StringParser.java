package utils;

import java.util.Arrays;
import java.util.List;

public class StringParser {
    public static List<String> splitByComma(String input) {
        return Arrays.asList(input.split(",", -1));
    }

    public static int parseToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("정수만 입력가능합니다.");
        }
    }

    public static String putBlank(String input) {
        StringBuilder stringBuilder = new StringBuilder(input);
        for (int i = 0; i < 5 - input.length(); i++) {
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
