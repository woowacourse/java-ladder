package calc;

import java.util.List;

public class Calc {
    private int result = 0;

    Calc(String input) {
        List<Integer> numbers = new Expression(input).getNumbers();
        if (numbers.isEmpty()) {
            throw new RuntimeException();
        }
        result = numbers.stream().reduce(0, (x, y) -> x + y);
    }

    public int getResult() {
        return result;
    }
}