package model.position;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;


public class Position {

    public static final int MIN_CACHED_POSITION = 0;
    public static final int MAX_CACHED_POSITION = 20;
    protected static final String NOT_ALLOWED_NEGATIVE_POSITION = "포지션(위치)은 음수가 될 수 없습니다.";
    private final int currentIndex;
    private static final Map<Integer, Position> positions = new HashMap<>();

    private Position(int currentIndex) {
        validateNotNegative(currentIndex);
        this.currentIndex = currentIndex;
    }

    void validateNotNegative(int index) {
        if (index < 0) {
            throw new IllegalStateException(NOT_ALLOWED_NEGATIVE_POSITION);
        }
    }

    static {
        IntStream.range(MIN_CACHED_POSITION, MAX_CACHED_POSITION)
                .forEach(position -> positions.put(position, new Position(position)));
    }

    public static Position valueOf(int index) {
        if (positions.containsKey(index)) {
            return positions.get(index);
        }
        Position position = new Position(index);
        positions.put(index, position);
        return position;
    }

    public boolean same(int other) {
        return currentIndex == other;
    }

    public int index() {
        return currentIndex;
    }

    public Position prior() {
        return valueOf(currentIndex - 1);
    }

    public int priorIndex() {
        return currentIndex - 1;
    }

    public Position next() {
        return valueOf(currentIndex + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return currentIndex == position.currentIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentIndex);
    }
}
