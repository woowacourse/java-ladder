package ladder.model;

import static ladder.model.ErrorMessage.EXCEPTION_HEIGHT_MINIMUM;

public class Height {
    private static final int MIN_HEIGHT = 2;
    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(EXCEPTION_HEIGHT_MINIMUM.getMessage());
        }
    }

    public int getHeight() {
        return height;
    }

}
