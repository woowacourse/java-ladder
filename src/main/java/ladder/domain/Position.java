package ladder.domain;

import java.util.Objects;

public class Position {
    private final int value;

    public Position(int value) {
        validateNegative(value);
        this.value = value;
    }

    private void validateNegative(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("위치는 음수 값일 수 없습니다.");
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
