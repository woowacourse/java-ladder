package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionParser {

    public static List<Integer> parseNumbers(List<String> seperators, String expression) {
        List<String> splittedInputs = Arrays.asList(expression.split(String.join("|", seperators)));

        return convertToIntegers(splittedInputs);
    }

    private static List<Integer> convertToIntegers(List<String> tokens) {
        return tokens.stream().mapToInt((token) -> Integer.parseInt(token)).boxed().collect(Collectors.toList());
    }
}
