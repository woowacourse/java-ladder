package ladder.domain;

import java.util.Objects;

public class Position {
    // [begin, end)
    private final int begin, end, current;

    // begin <= current < end
    public Position(int begin, int end, int current) {
        if (!(begin <= current && current < end)) {
            throw new IllegalArgumentException("i의 범위가 잘못 되었습니다. begin <= i < end");
        }
        this.begin = begin;
        this.end = end;
        this.current = current;
    }

    public Position add(int i) {
        return new Position(begin, end, current + i);
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

    public int toInt() {
        return current;
    }

    public boolean isLast() {
        return current + 1 == end;
    }

    public Position Last() {
        return new Position(begin, end, end - 1);
    }
}
