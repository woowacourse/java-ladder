package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DrawnHorizontalLine {
    private final int numPosition;
    private final List<Direction> directions;

    public DrawnHorizontalLine(List<Direction> directions) {
        this.directions = new ArrayList(directions); // 방어적 복사
        this.numPosition = directions.size();
    }

    public Position nextPosition(Position current) {
        return directions.get(current.toInt()).nextPosition(current);
    }

    public int getNumPosition() {
        return numPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrawnHorizontalLine that = (DrawnHorizontalLine) o;
        return numPosition == that.numPosition &&
                Objects.equals(directions, that.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numPosition, directions);
    }

    public boolean isDrawn(Position leftColumn) {
        return directions.get(leftColumn.toInt()) == Direction.RIGHT;
    }

    public Position createFirstColumnPosition() {
        return new Position(0, directions.size(), 0);
    }

    public Position createFirstLeftColumnPosition() {
        return new Position(0, directions.size() - 1, 0);
    }
}
