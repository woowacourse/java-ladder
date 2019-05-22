package ladder.engine.basic;

import java.util.Objects;

class Position {
    private final int position;
    private final int max;

    Position(final int position, final int max) {
        if (position < 0) {
            throw new IllegalArgumentException("0미만의 값은 위치 정보가 될 수 없습니다.");
        }
        if (position >= max) {
            throw new IllegalArgumentException("최대 값을 초과할 수 없습니다.");
        }

        this.position = position;
        this.max = max;
    }

    int getPosition() {
        return position;
    }

    boolean isFirst() {
        return position == 0;
    }

    boolean isLast() {
        return position == max - 1;
    }

    Position moveNext() {
        return new Position(position + 1, max);
    }

    Position movePrevious() {
        return new Position(position - 1, max);
    }

    static Position first(int max) {
        return new Position(0, max);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
