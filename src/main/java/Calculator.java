import java.util.List;

public class Calculator {
    public int evaluate(String input) {
        if(input.isEmpty()) {
            return 0;
        }

        List<Integer> numbers = ExpressionParser.parseNumbers(
                InputParser.extractDelimiters(input),
                InputParser.extractExpression(input));

        return numbers.stream().mapToInt((i) -> i).sum();
    }
}
