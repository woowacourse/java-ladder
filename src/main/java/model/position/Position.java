package model.position;

import java.util.Objects;
import java.util.stream.IntStream;


public class Position {
    private static final int LOW_CACHED_POSITION = 0;
    private static final int HIGH_CACHED_POSITION = 20;
    private static final Position[] cache = new Position[HIGH_CACHED_POSITION];
    protected static final String NOT_ALLOWED_NEGATIVE_POSITION = "포지션(위치)은 음수가 될 수 없습니다.";
    private final int currentIndex;


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
        IntStream.range(LOW_CACHED_POSITION, HIGH_CACHED_POSITION)
                .forEach(position -> cache[position] = new Position(position));
    }

    public static Position valueOf(int index) {
        if (cache.length > index && index >= LOW_CACHED_POSITION) {
            return cache[index];
        }
        return new Position(index);
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
