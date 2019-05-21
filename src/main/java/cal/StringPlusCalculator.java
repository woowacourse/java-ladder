package cal;

import java.util.regex.Pattern;

public class StringPlusCalculator {
    private static final String DEFAULT_SEPARATOR = "[,|:]";
    private static final String NUMBER_REGEX = "[0-9]*";
    private static final int NON_CUSTOM_DELIMITER = -1;
    private static final int VALID_BOUND_NUMBER = 0;

    public static int calculate(String expression) {
        expression = checkBlank(expression);
        int nPosition = checkCustomSeparator(expression);
        String seperator = separatorGenerator(expression, nPosition);
        String target = extractExpression(expression, nPosition);
        String[] numbers = target.split(seperator);

        checkDelimiters(numbers);
        checkNegative(numbers);

        return sum(numbers);
    }

    private static String checkBlank(String expression) {
        if ("".equals(expression)) {
            expression = "0";
        }
        return expression;
    }

    private static int checkCustomSeparator(String expression) {
        return expression.indexOf("\n");
    }

    private static String separatorGenerator(String expression, int nPosition) {
        if (nPosition != NON_CUSTOM_DELIMITER) {
            String operator = expression.substring(2, nPosition);
            return "[,|:|" + operator + "]";
        }
        return DEFAULT_SEPARATOR;
    }

    private static String extractExpression(String expression, int nPosition) {
        return expression.substring(nPosition + 1);
    }

    private static void checkDelimiters(String[] numbers) {
        for (String number : numbers) {
            checkDelimiter(number);
        }
    }

    private static void checkDelimiter(String number) {
        if (!Pattern.matches(NUMBER_REGEX, number))
            throw new IllegalArgumentException();
    }

    private static void checkNegative(String[] numbers) {
        for (String number : numbers) {
            if (Integer.parseInt(number) < VALID_BOUND_NUMBER) throw new IllegalArgumentException();
        }
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
