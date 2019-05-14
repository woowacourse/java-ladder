package calculator.domain;

import java.util.List;
import java.util.Objects;

public class Calculator {
    private final Expression expression;

    public Calculator(String expression) {
        this.expression = new Expression(expression);
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

    int calculate() {
        List<Number> numbers = expression.getNumbers();
        int sum = 0;

        if(numbers.size() == 1){
            return 0;
        }

        for (Number number : numbers) {
            sum += number.getNumber();
        }
        return sum;
    }
}
