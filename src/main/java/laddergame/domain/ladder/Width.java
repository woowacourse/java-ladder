package laddergame.domain.ladder;

public class Width {
    private final int value;

    public Width(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("사다리 너비는 양수여야합니다.");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
