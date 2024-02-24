package domain;

import static domain.ExceptionType.POSITION_OVERFLOW;

import java.util.List;
import java.util.Objects;

class Position {
    private final int rawPosition;
    private final int maxPosition;


    Position(int rawPosition, int maxPosition) {
        validateRange(rawPosition, maxPosition);
        this.rawPosition = rawPosition;
        this.maxPosition = maxPosition;
    }

    private void validateRange(int rawPosition, int maxPosition) {
        if (rawPosition < 0 || rawPosition > maxPosition) {
            throw new LadderGameException(POSITION_OVERFLOW);
        }
    }

    Position move(List<Boolean> bridges) {
        Boolean canGoRight = getCanGo(bridges, rawPosition);
        Boolean canGoLeft = getCanGo(bridges, rawPosition - 1);
        if (canGoRight) {
            return new Position(rawPosition + 1, maxPosition);
        }
        if (canGoLeft) {
            return new Position(rawPosition - 1, maxPosition);
        }
        return this;
    }

    private Boolean getCanGo(List<Boolean> bridges, int startPosition) {
        Boolean canGoRight;
        try {
            canGoRight = bridges.get(startPosition);
        } catch (IndexOutOfBoundsException e) {
            canGoRight = false;
        }
        return canGoRight;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        var that = (Position) obj;
        return this.rawPosition == that.rawPosition &&
                this.maxPosition == that.maxPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rawPosition, maxPosition);
    }

    int getRawPosition() {
        return rawPosition;
    }
}
