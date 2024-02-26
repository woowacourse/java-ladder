package ladder.domain.player;

import java.util.Objects;

public class Position {
    private static final int MINIMUM_POSITION = 1;

    private int position;

    public Position(final int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(final int position) {
        if (position < MINIMUM_POSITION) {
            throw new IllegalArgumentException(
                    String.format("참여자의 위치는 %d보다 작을 수 없습니다.", MINIMUM_POSITION));
        }
    }

    public void add(final int value) {
        this.position += value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
