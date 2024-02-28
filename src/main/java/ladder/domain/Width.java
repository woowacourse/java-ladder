package ladder.domain;

public record Width(int value) {
    private static final int MIN_WIDTH = 2;

    public Width {
        if (value < MIN_WIDTH) {
            throw new IllegalArgumentException(
                    "너비는 %d 이상이여야 합니다: %d".formatted(MIN_WIDTH, value)
            );
        }
    }

    public boolean isLargerThan(int size) {
        return size < value;
    }
}
