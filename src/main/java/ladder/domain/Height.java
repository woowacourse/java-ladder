package ladder.domain;

public class Height {
    private static int MIN_HEIGHT = 1;
    private static String HEIGHT_EXCEPTION_MESSAGE = "높이는 양수로 입력해주세요.";
    private final int height;

    public Height(final int height) {
        isLowerLimit(height);
        this.height = height;
    }

    private void isLowerLimit(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(HEIGHT_EXCEPTION_MESSAGE);
        }
    }

    public int getHeight() {
        return height;
    }
}
