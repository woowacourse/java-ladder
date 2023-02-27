package domain.ladder;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private final int height;

    public Height(int height) {
        validate(height);
        this.height = height;
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 1이상 100이하의 자연수만 가능합니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
