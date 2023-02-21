package ladder.domain;

public class Height {
    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 100;
    private static final String INVALID_HEIGHT_MESSAGE =
            "사다리 높이는 최소 " + MINIMUM_HEIGHT + ", 최대 " + MAXIMUM_HEIGHT + "까지 가능합니다.";

    private final int height;

    public Height(final int number) {
        validate(number);
        this.height = number;
    }

    private void validate(final int number) {
        if (number < MINIMUM_HEIGHT || number > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(INVALID_HEIGHT_MESSAGE);
        }
    }

    public int getHeight() {
        return height;
    }
}
