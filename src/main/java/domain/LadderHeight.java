package domain;

public class LadderHeight {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10;

    private final int value;

    public LadderHeight(int value) {
        validateHeight(value);
        this.value = value;
    }

    public boolean hasLengthOf(int currentFloor) {
        return currentFloor == value;
    }

    private void validateHeight(int height) {
        if (isHeightOutOfRange(height)) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상 10 이하여야 합니다.");
        }
    }

    private boolean isHeightOutOfRange(int height) {
        return height < MIN_HEIGHT || height > MAX_HEIGHT;
    }
}
