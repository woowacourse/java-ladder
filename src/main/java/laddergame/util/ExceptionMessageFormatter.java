package laddergame.util;

import java.util.Formatter;

public class ExceptionMessageFormatter {

    private final static Formatter formatter = new Formatter();

    private final static String MESSAGE_CONTAINING_INPUT_STRING = "%s (입력값: %s)";
    private final static String MESSAGE_CONTAINING_INPUT_DIGIT = "%s (입력값: %d)";

    public static String format(final String message, final String input) {
        final Formatter formatted = formatter.format(MESSAGE_CONTAINING_INPUT_STRING, message, input);
        final String result = formatted.toString();
        formatter.flush();
        return result;
    }

    public static String format(final String message, final int input) {
        final Formatter formatted = formatter.format(MESSAGE_CONTAINING_INPUT_DIGIT, message, input);
        final String result = formatted.toString();
        formatter.flush();
        return result;
    }
}
