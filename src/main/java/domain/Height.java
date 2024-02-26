package domain;

import exception.domain.HeightExceptionMessage;

public class Height {

    public static final int MIN_OF_HEIGHT = 1;
    public static final int MAX_OF_HEIGHT = 100;
    public static final int FLOOR_CALCULATION = 1;
    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    public boolean isEnd(int nowFloor) {
        return this.height <= nowFloor + FLOOR_CALCULATION;
    }

    private void validate(int height) {
        if (height < MIN_OF_HEIGHT || MAX_OF_HEIGHT < height) {
            throw new IllegalArgumentException(HeightExceptionMessage.OUT_OF_RANGE_HEIGHT.getExceptionMessage());
        }
    }
}
