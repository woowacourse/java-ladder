package ladder.domain;

public record Height(int value) {
    private static final int MIN_HEIGHT = 1;

    public Height {
        validate(value);
    }

    private void validate(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 %d이상입니다.".formatted(MIN_HEIGHT));
        }
    }
}
