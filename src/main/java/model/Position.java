package model;

public class Position {
    private final int value;

    Position() {
        this(0);
    }

    Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("참가자의 위치는 음수가 될 수 없습니다.");
        }
        this.value = value;
    }
}
