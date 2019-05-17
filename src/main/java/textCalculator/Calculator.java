package textCalculator;

public class Calculator {
    public static int calculate(String expression) {
        Delimiter delimiter = new Delimiter();
        expression = nullExpressionCorrector(expression);
        expression = delimiter.extractCustomDelimiters(expression);
        expression = emptyExpressionCorrector(expression);
        String[] tokens = expression.split("[" + delimiter.toString() + "]");
        return add(tokens);
    }

    private static int add(String[] splitedExpression) {
        int result = 0;
        for (String s : splitedExpression) {
            result += getNonNegativeInteger(s);
        }
        return result;
    }

    private static String nullExpressionCorrector(String expression) {
        if (expression == null) return "0";
        return expression;
    }

    private static String emptyExpressionCorrector(String expression) {
        if (expression.isEmpty()) return "0";
        return expression;
    }

    private static int getNonNegativeInteger(String input) {
        int number = Integer.parseInt(input);
        if (number < 0) throw new IllegalArgumentException();
        return number;
    }
}

