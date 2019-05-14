package calculator;

public class StringCalculator {
    private static final int SPLIT_BOUNDARY = 2;
    private static final int SEPARATOR_LENGTH = 1;
    private static final int SEPARATOR_GROUP = 0;
    private static final int SEPARATOR = 1;

    //TODO 로직, 예외처리부분 보강
    public String createCustomSeparator(String input) {
        if (input == null || input.isEmpty()) {
            return null;
        }
        String[] splitInput = input.split("\\n");
        isValidSplitInput(splitInput.length, SPLIT_BOUNDARY);

        String[] split = splitInput[SEPARATOR_GROUP].split("//");
        isValidSplitInput(split.length, SPLIT_BOUNDARY);
        isValidSplitInput(split[SEPARATOR].length(), SEPARATOR_LENGTH);

        return split[SEPARATOR];
    }
    private void isValidSplitInput(int length, int splitBoundary) {
        if (length != splitBoundary) {
            throw new IllegalArgumentException();
        }
    }
}
