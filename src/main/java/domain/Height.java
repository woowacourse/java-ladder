package domain;

public class Height {

    private final int height;

    private static final String NOT_POSITIVE_ERROR_MESSAGE = "[ERROR] 양의 정수만 입력해주세요.";
    private static final int  HEIGHT_MIN_SIZE = 0;

    public Height(int height) {
        checkNegativeNumber(height);
        this.height = height;
    }

    public boolean isSameHeight(int count) {
        return count == height;
    }

    private void checkNegativeNumber(int height) {
        if (height <= HEIGHT_MIN_SIZE) {
            throw new IllegalArgumentException(NOT_POSITIVE_ERROR_MESSAGE);
        }
    }
}
