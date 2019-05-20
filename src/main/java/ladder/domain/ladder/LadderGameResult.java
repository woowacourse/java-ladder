package ladder.domain.ladder;

import java.util.Objects;

class LadderGameResult {
    private final Direction direction;
    private final int position;

    private LadderGameResult(int position, Direction direction) {
        this.position = position;
        this.direction = direction;
    }

    static LadderGameResult firstPoint(boolean tmp) {
        return new LadderGameResult(0, Direction.firstDirection(tmp));
    }

    LadderGameResult nextPoint(int maxPosition, boolean tmp) {
        if (maxPosition > position + 1) {
            return new LadderGameResult(position + 1, direction.nextDirection(tmp));
        }
        if (maxPosition == position + 1) {
            return new LadderGameResult(position + 1, direction.lastDirection());
        }
        throw new IllegalArgumentException();
    }

    static LadderGameResult of(int position, Direction direction) {
        return new LadderGameResult(position, direction);
    }

    int nextPointPosition() {
        return position + direction.move();
    }

    boolean isRightDirection() {
        return direction.equals(Direction.of(false, true));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderGameResult point = (LadderGameResult) o;
        return direction.equals(point.direction)
                && position == point.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }
}