package calculator;

import javafx.geometry.Pos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final int SPLIT_BOUNDARY = 2;
    private static final int SEPARATOR_LENGTH = 1;
    private static final int SEPARATOR = 1;
    private static final String NEW_LINE = "\n";

    private static final String AFTER_SEPARATOR = "//";

    private CustomSeparatorGroup customSeparatorGroup;

    StringCalculator() {
        customSeparatorGroup = new CustomSeparatorGroup();
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
        String[] temp = expression.split(customSeparatorGroup.combineSeparatorToRegex());
        int[] result = new int[temp.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.parseInt(temp[i]);
        }
        return result;
    }

    public String[] splitByEnter(String input) {
        return input.split(NEW_LINE, 2);
    }

    public Positive add(String input) {
        if (isBlankOrNull(input)) {
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

    private int[] splitExpression(String[] temp) {
        if (temp.length == 1) {
            return splitBySeparator(temp[0]);
        }
        customSeparatorGroup.addCustomSeparator(createCustomSeparator(temp[0]));
        return splitBySeparator(temp[1]);
    }

    private boolean isBlankOrNull(String input) {
        return input == null || input.isEmpty();
    }
}
