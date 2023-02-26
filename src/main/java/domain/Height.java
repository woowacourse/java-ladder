package domain;

import static utils.ErrorMessage.*;

public class Height {

    private static final int MINIMUM_HEIGHT = 1;
    private static final int MAXIMUM_HEIGHT = 100;

    private final int height;

    private Height(int height) {
        this.height = height;
    }

    public static Height from(int height) {
        validateHeight(height);
        return new Height(height);
    }

    private static void validateHeight(int height) {
        if (height < MINIMUM_HEIGHT || height > MAXIMUM_HEIGHT) {
            throw new IllegalArgumentException(
                String.format(INVALID_LADDER_HEIGHT.getMessage(),
                        MINIMUM_HEIGHT, MAXIMUM_HEIGHT));
        }
    }

    public int getHeight() {
        return height;
    }

}
