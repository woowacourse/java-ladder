package cal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private static final String DEFAULT_DELIMITERS = ",:";
    private static final String FORBIDDEN_DELIMITERS = "-";

    private static int add(String[] splitedExpression) {
        int result = 0;
        for (String s : splitedExpression) {
            int number = checkNegative(s);
            result += number;
        }
        return result;
    }

    public static int calculate(String expression) {
        expression = checkNull(expression);
        Matcher m = Pattern.compile("//(.*)\n(.*)").matcher(expression);
        String customDelimiter = "";
        if (m.find()) {
            customDelimiter = m.group(1);
            checkForbiddenDelimeter(customDelimiter);
            expression = m.group(2);
        }
        expression = checkEmpty(expression);
        String[] tokens = expression.split("[" + customDelimiter + DEFAULT_DELIMITERS + "]");
        return add(tokens);
    }

    public static String checkNull(String input) {
        if (input == null) return "0";
        return input;
    }

    public static String checkEmpty(String input) {
        if (input.isEmpty()) return "0";
        return input;
    }

    public static int checkNegative(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) throw new IllegalArgumentException();
        return number;
    }

    public static void checkForbiddenDelimeter(String input) {
        if (input.contains(FORBIDDEN_DELIMITERS)) throw new IllegalArgumentException();
    }
}

