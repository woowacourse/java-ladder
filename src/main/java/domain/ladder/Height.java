package domain.ladder;

public class Height {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 100;

    private final int value;

    public Height(final int value) {
        validateRange(value);
        this.value = value;
    }

    private static void validateRange(final int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] %d 이상 %d 이하의 자연수만 입력해 주세요.", MIN_HEIGHT, MAX_HEIGHT)
            );
        }
    }

    public int getValue() {
        return value;
    }
}
