package textCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimiter {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String FORBIDDEN_DELIMITERS = "-";

    private String delimiterText;

    public Delimiter() {
        delimiterText = DEFAULT_DELIMITERS;
    }

    public String extractCustomDelimiters(String expression) {
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(expression);
        if (m.find()) {
            checkForbiddenDelimeter(m.group(1));
            delimiterText += m.group(1);
            expression = m.group(2);
        }
        return expression;
    }

    private static void checkForbiddenDelimeter(String input) {
        if (input.contains(FORBIDDEN_DELIMITERS)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return delimiterText;
    }
}
