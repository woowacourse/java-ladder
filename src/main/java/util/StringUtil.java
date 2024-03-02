package util;

public class StringUtil {
    private static final String NUMBER_EXCEPTION_MESSAGE = "[ERROR] rejected value: %s - 숫자만 가능합니다.";
    private static final String DELIMITER_EXCEPTION_MESSAGE = "[ERROR] rejected value: %s - 올바를 구분자로 구분해야 합니다.";

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
        if (!Delimiter.COMMA.matches(value)) {
            throw new IllegalArgumentException(String.format(DELIMITER_EXCEPTION_MESSAGE, value));
        }
        return value.split(Delimiter.COMMA.getValue());
    }
}
