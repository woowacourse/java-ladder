package ladder.domain.laddergame;

import java.util.Objects;

public class Position {
    private static final int MINIMUM_POSITION = 0;
    private static final int MOVING_RIGHT = 1;
    private static final int MOVING_LEFT = -1;
    private static final String ERROR_OF_POSITION = String.format("%d보다 작은 숫자로 이동할 수 없습니다", MINIMUM_POSITION);
    private final int value;

    public Position(final int value) {
        validateValueOfPosition(value);
        this.value = value;
    }

    private void validateValueOfPosition(final int value) {
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
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Position position = (Position) o;
        return value == position.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
