package ladder;

import java.util.Objects;

public class Position {
    private int position;
    private Direction direction;

    private Position(int position, final Direction direction) {
        checkUnderZero(position);
        this.position = position;
        this.direction = direction;
    }

    private void checkUnderZero(int position) {
        if (position < 0) {
            throw new IllegalArgumentException("위치는 음수 일 수는 없습니다.");
        }
    }

    public static Position first(boolean hasRight) {
        return new Position(0, Direction.first(hasRight));
    }

    public Position next(int nextPosition, boolean hasRight) {
        return new Position(nextPosition, direction.next(hasRight));
    }

    public Position last(int lastPosition) {
        return new Position(lastPosition, direction.last());
    }

    public void move(Direction direction) {
        position = position + direction.move();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position &&
                Objects.equals(direction, position1.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, direction);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(direction);
        return stringBuilder.toString();
    }
}
