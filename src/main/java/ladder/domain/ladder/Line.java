package ladder.domain.ladder;

import java.util.List;

public class Line {
    private static final String LINE = "|";

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
            stringBuilder.append(LINE);
            stringBuilder.append(direction);
        }
        return stringBuilder.toString();
    }
}
