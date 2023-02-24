package domain.player;

import domain.ladder.Line;
import domain.ladder.LinePoint;
import java.util.List;
import java.util.Objects;

public class Position {

    private static final int LEFT_POINT_CONSTANT = 2;
    private static final int RIGHT_POINT_CONSTANT = 1;

    private int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean isLeftSidePassable(Line line) {
        List<LinePoint> points = line.getPoints();
        return !isLeftEnd() && isPassable(points, position - LEFT_POINT_CONSTANT);
    }

    private boolean isPassable(List<LinePoint> points,
                               int index) {
        return points.get(index).isPassable();
    }

    private boolean isLeftEnd() {
        return position == 1;
    }

    public boolean isRightSidePassable(Line line) {
        List<LinePoint> points = line.getPoints();
        return !isRightEnd(getLastPosition(points)) && isPassable(points, position - RIGHT_POINT_CONSTANT);
    }

    private int getLastPosition(List<LinePoint> points) {
        return points.size() + 1;
    }

    private boolean isRightEnd(int rightEnd) {
        return position == rightEnd;
    }

    public void moveRight() {
        position++;
    }

    public void moveLeft() {
        position--;
    }

    public int getPosition() {
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
        Position otherPosition = (Position) other;
        return position == otherPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
