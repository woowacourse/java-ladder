package ladder.domain;

public class Height {

    private static final int HEIGHT_LOWER_BOUND_INCLUSIVE = 2;
    private static final String HEIGHT_ERROR_MESSAGE = "사다리 높이는 2이상이어야 합니다.";
    private final int height;

    public Height(int height) {
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height) {
        if (height < HEIGHT_LOWER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(HEIGHT_ERROR_MESSAGE);
        }
    }

    public int getHeight() {
        return height;
    }
}
