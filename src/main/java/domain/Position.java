package domain;

import static domain.ExceptionType.POSITION_OVERFLOW;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

class Position {

    private static final Map<Integer, Map<Integer, Position>> cache = new ConcurrentHashMap<>();

    static Position getCachedPosition(int rawPosition, int maxPosition) {
        if (cache.containsKey(maxPosition)) {
            Map<Integer, Position> cacheThatSameMaxPosition = cache.get(maxPosition);
            return cacheThatSameMaxPosition.computeIfAbsent(rawPosition, key -> new Position(key, maxPosition));
        }
        cache.computeIfAbsent(maxPosition, key -> new ConcurrentHashMap<>())
                .put(rawPosition, new Position(rawPosition, maxPosition));
        return getCachedPosition(rawPosition, maxPosition);
    }

    private final int rawPosition;
    private final int maxPosition;


    private Position(int rawPosition, int maxPosition) {
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
            return moveRight();
        }
        if (canGoLeft) {
            return moveLeft();
        }
        return this;
    }

    private Boolean getCanGo(List<Boolean> bridges, int nextRawPosition) {
        if (nextRawPosition < 0 || nextRawPosition >= maxPosition) {
            return false;
        }
        return bridges.get(nextRawPosition);
    }

    private Position moveRight() {
        return Position.getCachedPosition(rawPosition + 1, maxPosition);
    }

    private Position moveLeft() {
        return Position.getCachedPosition(rawPosition - 1, maxPosition);
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
