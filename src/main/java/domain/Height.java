package domain;

public class Height {

    private final static int MINIMUM_LENGTH_OF_HEIGHT = 1;
    private final static int MAXIMUM_LENGTH_OF_HEIGHT = 10;

    private final int height;

    public Height(final int height) {
        validateLengthOfHeight(height);
        this.height = height;
    }

    private void validateLengthOfHeight(final int height) {
        if (isNotPermittedLengthOfHeight(height)) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1이상 최대 10이하입니다.");
        }
    }

    private boolean isNotPermittedLengthOfHeight(int height) {
        return (height < MINIMUM_LENGTH_OF_HEIGHT) || (height > MAXIMUM_LENGTH_OF_HEIGHT);
    }

    public int getHeight() {
        return height;
    }
}
