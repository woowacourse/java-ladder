package model;

import java.util.Objects;

public class Position {
    private final int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("참가자의 위치는 음수가 될 수 없습니다.");
        }
        this.value = value;
    }


    public Position increment() {
        return new Position(value + 1);
    }

    public Position decrement() {
        return new Position(value - 1);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return getValue() == position.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}
