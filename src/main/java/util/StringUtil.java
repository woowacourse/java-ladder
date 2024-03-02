package util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    private static final String NUMBER_EXCEPTION_MESSAGE = "[ERROR] rejected value: %s - 숫자만 가능합니다.";

    private StringUtil() {
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NUMBER_EXCEPTION_MESSAGE, number));
        }
    }

    public static List<String> splitWithDelimiter(String value, String delimiter) {
        return Arrays.asList(value.split(delimiter));
    }
}
