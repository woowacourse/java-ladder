package cal;

public class StringPlusCalculator {
    public static int calculate(String expression) {
        int nPosition = checkCustomSeperator(expression);
        String seperator = seperatorGenerator(expression, nPosition);
        String target = extractExpression(expression, nPosition);

        String[] numbers = target.split(seperator);

        checkNegative(numbers);

        return sum(numbers);
    }

    private static int checkCustomSeperator(String expression) {
        return expression.indexOf("\n");
    }

    private static String seperatorGenerator(String expression, int nPosition) {
        if (nPosition != -1) {
            String operator = expression.substring(2, nPosition);
            return "[,|:|" + operator + "]";
        }
        return "[,|:]";
    }

    private static String extractExpression(String expression, int nPosition) {
        return expression.substring(nPosition + 1);
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
