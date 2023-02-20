package laddergame.domain;

public class Height {
    private final int value;

    public Height(final int value) {
        validatePositive(value);
        this.value = value;
    }

    private void validatePositive(final int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("높이는 양수여야합니다.");
        }
    }

    public int getValue() {
        return value;
    }
}
