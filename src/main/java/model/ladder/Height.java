package model.ladder;

public class Height {
    private static final int MINIMUM_HEIGHT = 1;

    private final int value;

    public Height(final int rawHeight) {
        validateHeight(rawHeight);
        this.value = rawHeight;
    }

    private void validateHeight(final int rawHeight) {
        if (rawHeight < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상이어야 합니다.");
        }
    }

    public boolean isNotEquals(final int lineSize) {
        return lineSize != value;
    }

    public int getHeight() {
        return value;
    }
}
