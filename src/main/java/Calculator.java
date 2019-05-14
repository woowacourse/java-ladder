import java.util.List;

public class Calculator {
    public int evaluate(String input) {

        List<Integer> numbers = ExpressionParser.parseNumbers(
                InputParser.extractDelimiters(input),
                InputParser.extractExpression(input));

        return numbers.stream().mapToInt((i) -> i).sum();
    }
}
