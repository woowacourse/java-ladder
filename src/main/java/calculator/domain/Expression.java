package calculator.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Expression {
    private static final int LOCATION_OF_DELIMITER = 2;
    private static final int EXPRESSION_START_POINT = 4;
    private static final String CUSTOM_PATTERN = "//.*\\n.*";
    private static final String COMMA_OR_COLON = ",|:";

    private final String expression;

    public Expression(String expression) {
        if (StringUtils.isBlank(expression)) {
            expression = "0";
        }
        this.expression = expression;
    }

    Numbers getNumbers() {
        List<Number> numbers =  splitExpression().stream()
                .map(Number::new)
                .collect(Collectors.toList());
        return new Numbers(numbers);
    }

    List<String> splitExpression() {
        if (expression.matches(CUSTOM_PATTERN)) {
            String splitedExpression = this.expression.substring(EXPRESSION_START_POINT);
            return Arrays.asList(splitedExpression
                    .split(Character.toString(this.expression.charAt(LOCATION_OF_DELIMITER))));
        }
        return Arrays.asList(expression.split(COMMA_OR_COLON));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Expression)) return false;
        Expression that = (Expression) o;
        return Objects.equals(expression, that.expression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expression);
    }
}
