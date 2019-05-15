package calc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Expression {
    private static final String CUSTOM_DELIMITER_EXTRACTOR = "//|\n";

    private List<Integer> numbers;

    public Expression(String input) {
        if (input == null || input.isBlank()) {
            numbers = Arrays.asList(0);
            return;
        }
        numbers = validate(parse(tokenize(input)));
    }

    private List<String> tokenize(String input) {
        String delimiter = ",|:";
        String[] temp = input.split(CUSTOM_DELIMITER_EXTRACTOR);
        if (temp.length != 1) {
            delimiter += "|" + temp[1];
        }
        String expression = temp[temp.length - 1];
        return Arrays.asList(expression.split(delimiter));
    }

    private List<Integer> parse(List<String> tokens) {
        return tokens.stream()
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
    }

    private List<Integer> validate(List<Integer> numbers) {
        try {
            return (numbers.stream().map(x -> x < 0)
                    .reduce(false, (x, y) -> x | y))
                    ? Arrays.asList()
                    : numbers;
        } catch (NumberFormatException e) {
            return Arrays.asList();
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}