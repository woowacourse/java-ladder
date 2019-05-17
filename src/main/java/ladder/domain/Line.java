package ladder.domain;

import java.util.List;

public class Line {
    private final List<Direction> directions;

    public Line(List<Direction> directions) {
        this.directions = directions;
    }

    public Direction getDirection(Position position) {
        return directions.get(position.getValue());
    }

    @Override
    public String toString() {
        return "Line{" +
                "directions=" + directions +
                '}';
    }
}
