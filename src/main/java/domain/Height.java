package domain;

public class Height {

    private static final int MINIMUM_LENGTH_OF_HEIGHT = 1;
    private static final int MAXIMUM_LENGTH_OF_HEIGHT = 10;

    private final int value;

    public Height(final int value) {
        validateLengthOfHeight(value);
        this.value = value;
    }

    private void validateLengthOfHeight(final int height) {
        if (isNotPermittedLengthOfHeight(height)) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1이상 최대 10이하입니다.");
        }
    }

    private boolean isNotPermittedLengthOfHeight(int height) {
        return (height < MINIMUM_LENGTH_OF_HEIGHT) || (height > MAXIMUM_LENGTH_OF_HEIGHT);
    }

    public int getValue() {
        return this.value;
    }
}
