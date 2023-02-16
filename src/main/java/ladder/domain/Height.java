package ladder.domain;

import ladder.error.ErrorMessage;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10000;

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_HEIGHT_RANGE.getMessage());
        }
    }

}
