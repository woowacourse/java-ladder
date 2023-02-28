package domain;

import java.util.Objects;

public class Position {

    public static final String INVALID_POSITION = "Position은 0보다 작을 수 없습니다";
    private final int value;

    public Position(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(INVALID_POSITION);
        }
    }

    public Position minus() {
        return new Position(value - 1);
    }

    public Position minus(Position position) {
        return new Position(value - position.value);
    }

    public Position plus() {
        return new Position(value + 1);
    }

    public Position plus(Position position) {
        return new Position(value + position.value);
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
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return value;
    }
}
