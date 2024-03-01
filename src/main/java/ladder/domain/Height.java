package ladder.domain;

public record Height(int value) {
    private static final int MIN_HEIGHT = 1;

    public Height {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException(
                    "높이는 %d 이상이여야 합니다: %d".formatted(MIN_HEIGHT, value)
            );
        }
    }

    public void repeat(Runnable callback) {
        for (int i = 0; i < this.value; i++) {
            callback.run();
        }
    }

    public int value() {
        return value;
    }
}
