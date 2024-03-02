package util;

import java.util.regex.Pattern;

public class StringUtil {
    public static final String DEFAULT_DELIMITER = ",";
    private static final Pattern VALID_DELIMITER_PATTERN = Pattern.compile(
            "^[a-zA-Z가-힣\\d]+(" + DEFAULT_DELIMITER + "[a-zA-Z가-힣\\d]+)*$");
    private static final String NUMBER_EXCEPTION_MESSAGE = "[ERROR] rejected value: %s - 숫자만 가능합니다.";
    private static final String DELIMITER_EXCEPTION_MESSAGE = "[ERROR] rejected value: %s - 올바를 구분자가 필요합니다.";

    private StringUtil() {
    }

    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(NUMBER_EXCEPTION_MESSAGE, number));
        }
    }

    public static String[] splitWithDelimiter(String value) {
        if (!VALID_DELIMITER_PATTERN.matcher(value).matches()) {
            throw new IllegalArgumentException(String.format(DELIMITER_EXCEPTION_MESSAGE, value));
        }
        return value.split(DEFAULT_DELIMITER);
    }
}
