package ladder.domain;

import java.util.Objects;

public class Position {
    public static int MAX;
    public final int position;

    public Position(int position) {
        validateBiggerThanZero(position);
        validateNotBiggerThanMax(position);
        this.position = position;
    }

    private void validateBiggerThanZero(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("플레이어의 위치는 0보다 작을 수 없습니다.");
        }
    }

    private void validateNotBiggerThanMax(int position) {
        if (position > MAX) {
            throw new IllegalArgumentException("플레이어의 위치는 플레이어 수보다 작아야합니다.");
        }
    }

    public int getValue() {
        return position;
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

    @Override
    public String toString() {
        return "Position{" +
                "position=" + position +
                '}';
    }
}
