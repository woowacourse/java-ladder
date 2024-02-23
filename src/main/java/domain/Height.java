package domain;

import constant.domain.HeightExceptionMessage;

public class Height {

    public static final int MIN_OF_HEIGHT = 1;
    public static final int MAX_OF_HEIGHT = 100;

    public Height(int height) {
        validate(height);
    }

    private void validate(int height) {
        if (height < MIN_OF_HEIGHT || height > MAX_OF_HEIGHT) {
            throw new IllegalArgumentException(HeightExceptionMessage.OUT_OF_RANGE_HEIGHT.getExceptionMessage());
        }
    }
}
