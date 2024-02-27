package ladder.domain.player;

import ladder.domain.Direction;
import ladder.domain.ladder.Rung;

import java.util.List;
import java.util.Objects;

public class Position {
    private static final int MINIMUM_POSITION = 0;

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

    public Direction findMovableDirection(final List<Rung> rungs) {
        if (canMoveToLeft(rungs)) {
            return Direction.LEFT;
        }
        if (canMoveToRight(rungs)) {
            return Direction.RIGHT;
        }
        return Direction.CENTER;
    }

    private boolean canMoveToLeft(final List<Rung> rungs) {
        return position - 1 >= 0 && rungs.get(position - 1).isExist();
    }

    private boolean canMoveToRight(final List<Rung> rungs) {
        return position < rungs.size() && rungs.get(position).isExist();
    }

    public int getValue() {
        return position;
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
