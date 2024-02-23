package domain;

public class Height {
    private static final int MIN_HEIGHT = 1;

    private final int height;

    public Height(final int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("다리 길이는 %d 이상으로 입력해야합니다.".formatted(MIN_HEIGHT));
        }
    }

    public boolean isBiggerThan(int otherHeight) {
        return height > otherHeight;
    }
}
