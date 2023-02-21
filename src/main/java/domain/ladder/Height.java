package domain.ladder;

import utils.ErrorMessage;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(ErrorMessage.HEIGHT_ERROR.getMessage());
        }
    }

    public int getHeight() {
        return height;
    }
}
