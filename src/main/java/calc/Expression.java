package calc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
    private static final String CUSTOM_EXTRACTOR = "//|\n";
    private static final List<Integer> EMPTY_LIST = Arrays.asList();

    public static List<Integer> getTokens(String input) {
        if (input == null || input.trim().length() == 0) {
            return Arrays.asList(0);
        }
        return validate(parse(tokenize(input.trim())));
    }

    private static List<String> tokenize(String input) {
        String delimiter = ",|:"; // TODO: 차후 규칙을 외부로 빼내는 방안?
        List<String> parts = Arrays.asList(input.split(CUSTOM_EXTRACTOR));
        if (parts.size() != 1) {
            delimiter += "|" + parts.get(1);
        }
        String expression = parts.get(parts.size() - 1);
        return Arrays.asList(expression.split(delimiter));
    }

    private static List<Integer> parse(List<String> tokens) {
        return tokens.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> validate(List<Integer> numbers) {
        try {
            return (numbers.stream()
                    .map(x -> x < 0)
                    .reduce(false, (x, y) -> x | y))
                    ? EMPTY_LIST
                    : numbers;
        } catch (NumberFormatException e) {
            return EMPTY_LIST;
        }
    }
}