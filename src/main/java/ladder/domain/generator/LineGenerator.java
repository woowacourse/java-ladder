package ladder.domain.generator;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.RIGHT;
import static ladder.domain.Direction.STAY;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.Direction;
import ladder.domain.Line;

public class LineGenerator {

    public Line generate(final DirectionGenerator directionGenerator, final int directionCount) {
        final List<Direction> directions = generateDirections(directionGenerator, directionCount);
        return new Line(directions);
    }

    private List<Direction> generateDirections(final DirectionGenerator directionGenerator, final int directionCount) {
        final List<Direction> directions = new ArrayList<>();
        while (directions.size() < directionCount) {
            generateDirectionsStrategy(directionGenerator, directions, directionCount);
        }
        return directions;
    }

    private void generateDirectionsStrategy(final DirectionGenerator directionGenerator,
                                            final List<Direction> directions, final int directionCount) {
        if (directions.size() >= directionCount - 1) {
            addStayIfNotEnough(directions, directionCount);
            return;
        }
        addDirections(directionGenerator, directions);
    }

    private void addStayIfNotEnough(final List<Direction> directions, final int directionCount) {
        if (isNotEnough(directions, directionCount)) {
            directions.add(STAY);
        }
    }

    private boolean isNotEnough(final List<Direction> directions, final int directionCount) {
        return directions.size() == directionCount - 1;
    }

    private void addDirections(final DirectionGenerator directionGenerator, final List<Direction> directions) {
        final Direction direction = directionGenerator.generate();

        directions.add(direction);

        if (direction == RIGHT) {
            directions.add(LEFT);
        }
    }
}
