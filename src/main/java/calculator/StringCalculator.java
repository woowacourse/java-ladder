package calculator;

import java.util.Arrays;

public class StringCalculator {
    private static final int SPLIT_BOUNDARY = 2;
    private static final int SEPARATOR_LENGTH = 1;
    private static final int SEPARATOR = 1;
    private static final int NO_CUSTOM_SEPARATOR = 1;

    private static final String BEFORE_SEPARATOR = "//";
    private static final String ENTER = "\n";

    private CustomSeparators customSeparators;

    public StringCalculator() {
        customSeparators = new CustomSeparators();
    }

    public CustomSeparator createCustomSeparator(String input) {
        String[] unrefinedSeparator = input.split(BEFORE_SEPARATOR);
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
        return input.split(ENTER, 2);
    }

    public int add(String input) {
        if (isBlankOrNull(input)) {
            return 0;
        }
        String[] separatorAndExpression = splitByEnter(input);
        int[] expression = splitExpression(separatorAndExpression);
        return Arrays.stream(expression)
                .peek(i -> isNegative(i))
                .sum();
    }

    private int[] splitExpression(String[] separatorAndExpression) {
        if (separatorAndExpression.length == NO_CUSTOM_SEPARATOR) {
            return splitBySeparator(separatorAndExpression[0]);
        }
        customSeparators.addCustomSeparator(createCustomSeparator(separatorAndExpression[0]));
        return splitBySeparator(separatorAndExpression[1]);
    }

    private boolean isBlankOrNull(String input) {
        return input == null || input.isEmpty();
    }

    private void isNegative(int i) {
        if (i < 0) {
            throw new RuntimeException();
        }
    }
}
