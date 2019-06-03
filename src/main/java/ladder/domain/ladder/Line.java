package ladder.domain.ladder;

import java.util.List;

public class Line {
    private final List<Direction> directions;

    public Line(final List<Direction> directions) {
        this.directions = directions;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Direction direction : directions) {
            stringBuilder.append("|");
            stringBuilder.append(direction);
        }
        return stringBuilder.toString();
    }
}
