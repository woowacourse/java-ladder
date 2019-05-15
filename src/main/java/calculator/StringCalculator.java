package calculator;

public class StringCalculator {
    private static final int SPLIT_BOUNDARY = 2;
    private static final int SEPARATOR_LENGTH = 1;
    private static final int SEPARATOR = 1;

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
        return input.split("\n", 2);
    }

    public int add(String input) {
        if (isBlankOrNull(input)) return 0;
        String[] temp = splitByEnter(input);
        int[] expression = splitExpression(temp);
        return sum(expression);
    }

    private int[] splitExpression(String[] temp) {
        if (temp.length == 1) {
            return splitBySeparator(temp[0]);
        }
        customSeparatorGroup.addCustomSeparator(createCustomSeparator(temp[0]));
        return splitBySeparator(temp[1]);
    }

    private boolean isBlankOrNull(String input) {
        return input.isEmpty() || input == null;
    }

    private int sum(int[] expression) {
        int sum = 0;
        for (int i = 0; i < expression.length; i++) {
            isNegative(expression[i]);
            sum += expression[i];
        }
        return sum;
    }

    private void isNegative(int i) {
        if (i < 0) {
            throw new RuntimeException();
        }
    }
}
