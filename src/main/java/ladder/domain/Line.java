package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ladder.util.generator.DirectionGenerator;

public class Line {

    private final List<Direction> directions;

    public Line(final List<Direction> directions) {
        this.directions = directions;
    }

    public static Line of(final DirectionGenerator directionGenerator, final int count) {
        final List<Direction> directions = new ArrayList<>();
        while (directions.size() < count - 1) {
            final Direction direction = directionGenerator.generate();
            addDirection(directions, direction, count);
        }
        return new Line(directions);
    }

    private static void addDirection(final List<Direction> directions, final Direction direction, final int count) {
        directions.add(direction);

        if (direction == RIGHT) {
            directions.add(LEFT);
        }
        if (directions.size() == count - 1) {
            directions.add(STAY);
        }
    }

    public int moveFrom(final int position) {
        return position + directions.get(position).getValue();
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(directions);
    }
}
