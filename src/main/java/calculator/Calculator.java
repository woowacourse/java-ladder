package calculator;

import java.util.List;

public class Calculator {
    public int evaluate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        List<Integer> numbers = ExpressionParser.parseNumbers(
                InputParser.extractDelimiters(input),
                InputParser.extractExpression(input));
        checkMinus(numbers);
        return numbers.stream().mapToInt((i) -> i).sum();
    }

    private void checkMinus(List<Integer> numbers) throws RuntimeException {
        if (0 < numbers.stream().filter((number) -> number < 0).count()) {
            throw new RuntimeException();
        }
    }
}
