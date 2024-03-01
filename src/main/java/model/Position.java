package model;

public record Position(int value) {

    public Position() {
        this(0);
    }

    public Position {
        if (value < 0) {
            throw new IllegalArgumentException("참가자의 위치는 음수가 될 수 없습니다.");
        }
    }

    public Position increment() {
        return new Position(value + 1);
    }

    public Position decrement() {
        return new Position(value - 1);
    }
}
