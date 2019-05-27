package ladderGameSolo.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line {
    private List<Direction> directions;

    public Line(int height) {
        directions = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            directions.add(new Direction(false, false));
        }
    }

    public Direction getDirectionByIndex(int index) {
        return this.directions.get(index);
    }

    public void updateDirection(int index,Direction direction) {
        directions.set(index, direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(directions, line.directions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(directions);
    }
}
