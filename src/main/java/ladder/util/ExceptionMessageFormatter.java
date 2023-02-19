package ladder.util;

import java.util.Formatter;

public class ExceptionMessageFormatter {

    private final static Formatter formatter = new Formatter();

    private final static String MESSAGE_CONTAINING_INPUT_STRING = "%s (입력값: %s)";
    private final static String MESSAGE_CONTAINING_INPUT_DIGIT = "%s (입력값: %d)";

    public static String format(String message, String input) {
        Formatter formatted = formatter.format(MESSAGE_CONTAINING_INPUT_STRING, message, input);
        return formatted.toString();
    }

    public static String format(String message, int input) {
        Formatter formatted = formatter.format(MESSAGE_CONTAINING_INPUT_DIGIT, message, input);
        return formatted.toString();
    }
}
