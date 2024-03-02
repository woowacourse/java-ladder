package domain.ladder;

public record Height(int value) {
    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 10;

    public Height {
        validateRange(value);
    }

    private void validateRange(final int height) {
        final String errorMessage = String.format("높이는 %d 이상 %d 이하로 입력해 주세요.", MIN_HEIGHT, MAX_HEIGHT);
        if (MIN_HEIGHT > height || height > MAX_HEIGHT) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
