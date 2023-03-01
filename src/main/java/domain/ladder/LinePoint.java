package domain.ladder;

import domain.player.Position;
import java.util.Objects;

public class LinePoint {

    private final Direction direction;
    private final Position position;

    public LinePoint(Direction direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public int getDirectionValue() {
        return direction.getValue();
    }

    public Direction getDirection() {
        return direction;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LinePoint otherLinePoint = (LinePoint) other;
        return direction == otherLinePoint.direction && Objects.equals(position, otherLinePoint.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direction, position);
    }
}
