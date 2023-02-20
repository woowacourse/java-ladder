package laddergame.domain;

public class Width {
    public Width(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("사다리 너비는 양수여야합니다.");
        }
    }
}
