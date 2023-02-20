package ladder.model;

import static ladder.model.ErrorMessage.EXCEPTION_HEIGHT;

public class Height {
    private static final int MIN_HEIGHT = 2;
    private static final int MAX_HEIGHT = 100;
    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(EXCEPTION_HEIGHT.getMessage());
        }
    }

    public int getHeight() {
        return height;
    }

}
