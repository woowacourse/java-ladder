package ladder;

import java.util.Objects;

public class Position {
    private final int max;
    private int position;

    public Position(int position, int max) {
        checkUnderZero(position);
        checkMoreThanMax(position, max);
        this.position = position;
        this.max = max;
    }

    private void checkMoreThanMax(int position, int max) {
        if (position >= max) {
            throw new IllegalArgumentException("위치는 최대보다 작아야합니다.");
        }
    }

    private void checkUnderZero(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 음수 일 수는 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return max == position1.max &&
                position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, position);
    }
}
