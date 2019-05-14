package calculator.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private final String expression;

    public Calculator(String expression) {
        this.expression = expression;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Calculator)) return false;
        Calculator that = (Calculator) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }

    List<String> splitExpression() {
        return splitExpressionWithMatch();
    }

    private List<String> splitExpressionWithMatch() {
        if (expression.matches("//.*\\n.*")) {
            String splitedExpression = expression.substring(4);
            return Arrays.asList(splitedExpression.split(Character.toString(expression.charAt(2))));
        }
        return Arrays.asList(expression.split(",|:"));
    }
}
