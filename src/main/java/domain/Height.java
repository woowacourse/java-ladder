package domain;

public class Height {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 20;

    private final int value;

    private Height(int value) {
        validate(value);
        this.value = value;
    }

    public static Height from(int height) {
        return new Height(height);
    }

    private static void validate(int height) {
        if (height < MIN_HEIGHT || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(
                String.format("%d 이상 %d 이하의 숫자를 입력해 주세요.", MIN_HEIGHT, MAX_HEIGHT));
        }
    }

    public int getValue() {
        return value;
    }
}
