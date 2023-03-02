package ladder.domain.ladderGame;

import java.util.Objects;

public class Position {
    private static final int MINIMUM_POSITION = 0;
    private static final int MOVING_RIGHT = 1;
    private static final int MOVING_LEFT = -1;
    private static final String ERROR_OF_POSITION = String.format("%d보다 작은 숫자로 이동할 수 없습니다", MINIMUM_POSITION);
    private final int value;

    public Position(int value) {
        validateValueOfPosition(value);
        this.value = value;
    }

    private void validateValueOfPosition(int value) {
        if (value < 0) {
            throw new IllegalArgumentException(ERROR_OF_POSITION);
        }
    }

    public Position increase() {
        return new Position(value + MOVING_RIGHT);
    }

    public Position decrease() {
        return new Position(value + MOVING_LEFT);
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
