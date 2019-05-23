package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Calculator {
    private final Expression expression;

    public Calculator(final String expression) {
        this.expression = new Expression(expression);
    }

    int calculate() {
        List<Number> numbers = expression.getNumbers();
        Number sum = Number.zeroNumber();

        for (final Number number : numbers) {
            sum = sum.add(number);
        }
        return sum.getNumber();
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
