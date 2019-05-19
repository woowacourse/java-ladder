package ladder.domain;

import java.util.List;
import java.util.Objects;

public final class Line {
    private final List<Direction> directions;

    public Line(final List<Direction> directions) {
        this.directions = directions;
    }

    public int move(int position){
        return directions.get(position).move();
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