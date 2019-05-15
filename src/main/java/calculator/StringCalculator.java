package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int input(String formula) {
        if (formula == null || formula.isEmpty()) {
            return 0;
        }

        List<Integer> numbers = Arrays.stream(formula.split(","))
                .map(Integer::parseInt).collect(Collectors.toList());

        if (numbers.size() == 1) {
            return numbers.get(0);
        }

        return numbers.get(0) + numbers.get(1);
    }
}
