package domain;

public class Height {

    private final int height;

    public Height(final int height) {
        validateLengthOfHeight(height);
        this.height = height;
    }

    // TODO: 예외 메시지 추가
    private void validateLengthOfHeight(final int height) {
        if (height < 1 || height > 10) {
            throw new IllegalArgumentException();
        }
    }

    public int getHeight() {
        return height;
    }
}
