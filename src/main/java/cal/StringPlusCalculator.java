package cal;

public class StringPlusCalculator {

    public static final String DEFAULT_SAPERATOR = "[,|:]";

    public static int calculate(String expression) {
        expression = checkBlank(expression);
        int nPosition = checkCustomSeperator(expression);
        String seperator = seperatorGenerator(expression, nPosition);
        String target = extractExpression(expression, nPosition);
        String[] numbers = target.split(seperator);

        checkDelimeters(numbers);
        checkNegative(numbers);

        return sum(numbers);
    }

    private static String checkBlank(String expression) {
        if ("".equals(expression)) {
            expression = "0";
        }
        return expression;
    }

    private static int checkCustomSeperator(String expression) {
        return expression.indexOf("\n");
    }

    private static String seperatorGenerator(String expression, int nPosition) {
        if (nPosition != -1) {
            String operator = expression.substring(2, nPosition);
            return "[,|:|" + operator + "]";
        }
        return DEFAULT_SAPERATOR;
    }

    private static String extractExpression(String expression, int nPosition) {
        return expression.substring(nPosition + 1);
    }

    private static void checkDelimeters(String[] numbers) {
        for (String number : numbers) {
            checkDelimeter(number);
        }
    }

    private static void checkDelimeter(String number) {
        if (!number.matches("[0-9]*"))
            throw new IllegalArgumentException();
    }

    private static void checkNegative(String[] numbers) {
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) throw new RuntimeException();
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
