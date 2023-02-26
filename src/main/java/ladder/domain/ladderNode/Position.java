package ladder.domain.ladderNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    private final int MAX_POSITION = 100;
    private static final Map<Integer, Position> cache;

    private final int position;

    static {
        cache = new HashMap<>();
    }

    private Position(int position) {
        this.position = position;
        validateNegativePosition(position);
        validateMaxPosition(position);
    }

    public static Position from(int position) {
        if (cache.containsKey(position)) {
            return cache.get(position);
        }
        Position instance = new Position(position);
        cache.put(position, instance);
        return instance;
    }

    public Position increase(int distance) {
        return new Position(position + distance);
    }

    public Position decrease(int distance) {
        return new Position(position - distance);
    }

    private void validateNegativePosition(int position) {
        if (position < 0) {
            throw new IllegalStateException("플레이어의 시작 위치는 0 이상이어야 합니다.");
        }
    }

    private void validateMaxPosition(int position) {
        if (position > MAX_POSITION) {
            throw new IllegalStateException("플레이어의 위치는 100 이하 이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position that = (Position) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }
}
