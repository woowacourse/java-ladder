package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final int SPLIT_BOUNDARY = 2;
    private static final int SEPARATOR_LENGTH = 1;
    private static final int SEPARATOR = 1;
    private static final String NEW_LINE = "\n";

    private static final String AFTER_SEPARATOR = "//";

    private CustomSeparators customSeparators;

    public StringCalculator() {
        customSeparators = new CustomSeparators();
    }

    public CustomSeparator createCustomSeparator(String input) {
        String[] unrefinedSeparator = input.split(AFTER_SEPARATOR);
        isValidSplitInput(unrefinedSeparator.length, SPLIT_BOUNDARY);
        isValidSplitInput(unrefinedSeparator[SEPARATOR].length(), SEPARATOR_LENGTH);

        return new CustomSeparator(unrefinedSeparator[SEPARATOR]);
    }

    private void isValidSplitInput(int length, int splitBoundary) {
        if (length != splitBoundary) {
            throw new IllegalArgumentException();
        }
    }

    public int[] splitBySeparator(String expression) {
        String[] numbers = expression.split(customSeparators.combineSeparatorToRegex());
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public String[] splitByEnter(String input) {
        return input.split(NEW_LINE, SPLIT_BOUNDARY);
    }

    public Positive add(String input) {
        if (isBlank(input)) {
            return new Positive(0);
        }
        String[] temp = splitByEnter(input);
        int[] expression = splitExpression(temp);

        PositiveNumbers positiveNumbers = new PositiveNumbers(convertPositive(expression));
        return positiveNumbers.sum();
    }

    private List<Positive> convertPositive(int[] expression) {
        return Arrays.stream(expression)
                .mapToObj(Positive::new)
                .collect(Collectors.toList());
    }

    private int[] splitExpression(String[] expression) {
        if (expression.length == 1) {
            return splitBySeparator(expression[0]);
        }
        customSeparators.addCustomSeparator(createCustomSeparator(expression[0]));
        return splitBySeparator(expression[1]);
    }

    private boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }
}
