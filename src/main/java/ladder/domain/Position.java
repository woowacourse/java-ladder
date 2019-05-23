package ladder.domain;

import java.util.Objects;

public class Position {
    private final int begin, end, current;

    public Position(int begin, int end, int current) {
        if (!(begin <= current && current < end)) {
            throw new IndexOutOfBoundsException(
                    String.format("current(=%d)의 범위는 [%d, %d) 이여야 합니다.", current, begin, end)
            );
        }
        this.begin = begin;
        this.end = end;
        this.current = current;
    }

    public Position at(int current) {
        return new Position(begin, end, current);
    }

    public Position prev() {
        return new Position(begin, end, current - 1);
    }

    public Position next() {
        return new Position(begin, end, current + 1);
    }

    public int toInt() {
        return current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return begin == position.begin &&
                end == position.end &&
                current == position.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(begin, end, current);
    }
}
