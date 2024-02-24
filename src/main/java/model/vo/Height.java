package model.vo;

public class Height {
    private static final int MIN_LADDER_HEIGHT = 1;
    private final int value;

    public Height(int value) {
        validateHeight(value);
        this.value = value;
    }

    private void validateHeight(int value) {
        if (value < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 " + MIN_LADDER_HEIGHT + " 이상이어야한다");
        }
    }

    public int getValue() {
        return value;
    }
}
