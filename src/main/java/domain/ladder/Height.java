package domain.ladder;

import exception.PositiveException;

public class Height {

    private final int height;


    private static final int HEIGHT_MIN_SIZE = 0;

    public Height(int height) {
        checkNegativeNumber(height);
        this.height = height;
    }

    public boolean isSameHeight(int count) {
        return count == height;
    }

    private void checkNegativeNumber(int height) {
        if (height <= HEIGHT_MIN_SIZE) {
            throw new PositiveException();
        }
    }
}
