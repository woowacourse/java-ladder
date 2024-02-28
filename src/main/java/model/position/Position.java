package model.position;

import java.util.Objects;


public class Position {
    private final int currentIndex;

    protected Position(int currentIndex) {
        validateNotNegative(currentIndex);
        this.currentIndex = currentIndex;
    }

    void validateNotNegative(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("포지션(위치)은 음수가 될 수 없습니다.");
        }
    }

    public boolean same(int other) {
        return currentIndex == other;
    }

    public int index() {
        return currentIndex;
    }

    public Position prior() {
        return CachedPosition.valueOf(currentIndex - 1);
    }

    public int priorIndex() {
        return currentIndex - 1;
    }

    public Position next() {
        return CachedPosition.valueOf(currentIndex + 1);
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
