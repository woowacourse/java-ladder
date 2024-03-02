package domain.ladder;

public record Height(int value) {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10;

    public Height {
        validateRange(value);
    }

    private void validateRange(final int value) {
        if (value < MIN_HEIGHT || value > MAX_HEIGHT) {
            throw new IllegalArgumentException(
                    String.format("사다리의 높이는 %d이상 %d이하 이어야 합니다.", MIN_HEIGHT, MAX_HEIGHT));
        }
    }
}
