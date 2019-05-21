package calculator.domain;

import java.util.Objects;

public class Calculator {
    private final Expression expression;

    public Calculator(final String expression) {
        this.expression = new Expression(expression);
    }

    public int plusAllNumbers() {
        Numbers numbers = expression.getNumbers();
        return numbers.sum();
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
}
