package ladder.domain;

public record Height(int value) {
    private static final int MIN_HEIGHT = 1;

    public Height {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException("높이는 %d이상입니다.".formatted(MIN_HEIGHT));
        }
    }
}
