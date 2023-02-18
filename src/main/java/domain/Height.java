package domain;

public class Height {

    private static final int HEIGHT_LOWER_BOUND_INCLUSIVE = 1;
    private static final int HEIGHT_UPPER_BOUND_INCLUSIVE = 100;
    public static final String HEIGHT_RANGE_ERROR_MESSAGE = "사다리 높이는 1 ~ 100만 가능합니다.";

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (isOutOfRange(height)) {
            throw new IllegalArgumentException(HEIGHT_RANGE_ERROR_MESSAGE);
        }
    }

    private boolean isOutOfRange(int height) {
        return !(HEIGHT_LOWER_BOUND_INCLUSIVE <= height
                && height <= HEIGHT_UPPER_BOUND_INCLUSIVE);
    }

    public int getHeight() {
        return this.height;
    }

}
