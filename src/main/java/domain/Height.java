package domain;

public class Height {
    private final static int MINIMUM_HEIGHT = 1;

    private final int height;

    public Height(final int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("다리 길이는 1 이상으로 입력해야합니다.");
        }
    }

    public boolean isBiggerThan(int buildHeight) {
        return height > buildHeight;
    }
}
