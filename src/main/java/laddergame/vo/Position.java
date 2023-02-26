package laddergame.vo;

import java.util.Objects;

public class Position implements Comparable<Position> {
    private final int position;

    public Position(int position) {
        validateIsPositive(position);
        this.position = position;
    }

    private void validateIsPositive(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 0 이상입니다");
        }
    }

    public Position increase() {
        return new Position(position + 1);
    }

    public Position decrease() {
        return new Position(position - 1);
    }

    @Override
    public int compareTo(Position p) {
        return position - p.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position p = (Position) o;
        return position == p.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int getPosition() {
        return position;
    }
}
