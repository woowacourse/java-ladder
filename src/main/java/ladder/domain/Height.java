package ladder.domain;

public class Height {

    public static final int MIN_HEIGHT_RANGE = 1;
    public static final int MAX_HEIGHT_RANGE = 100;

    private final int height;

    public Height(String input) {
        int number = changeInputToInteger(input);
        validateNumberIsIntRange(number);
        this.height = number;
    }

    private void validateNumberIsIntRange(int number) {
        if (number < MIN_HEIGHT_RANGE || number > MAX_HEIGHT_RANGE) {
            throw new IllegalArgumentException();
        }
    }

    private int changeInputToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }

    public int getHeight() {
        return height;
    }
}
