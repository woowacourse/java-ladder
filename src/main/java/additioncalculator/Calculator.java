package additioncalculator;

import java.util.List;

public class Calculator {
    private final static int DEFAULT_VALUE = 0;

    public static int calculate(List<Integer> numbers) {
        int sum = DEFAULT_VALUE;

        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }
}
