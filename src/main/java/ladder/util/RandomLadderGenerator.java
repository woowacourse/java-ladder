package ladder.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import ladder.domain.Direction;
import ladder.domain.Line;

public class RandomLadderGenerator {

    private static final int FIRST_MIDDLE_INDEX = 1;
    private static final int START_END_COUNT = 2;

    private final Random random = new Random();

    public List<Line> generate(int width, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            Line line = generateLine(width);
            lines.add(line);
        }
        return lines;
    }

    private Line generateLine(int size) {
        List<Direction> directions = generateDirections(size);
        adjustMiddleDirectionsIfAllDown(directions);
        return new Line(size, directions);
    }

    private List<Direction> generateDirections(int size) {
        List<Direction> directions = new ArrayList<>() {{
            add(randomStartDirection());
        }};
        for (int i = FIRST_MIDDLE_INDEX; i < size - 1; i++) {
            Direction previous = directions.get(i - 1);
            directions.add(randomMiddleDirection(previous));
        }
        Direction previous = directions.get(size - 2);
        directions.add(generateEndDirection(previous));
        return directions;
    }

    private Direction randomStartDirection() {
        return randomDirection();
    }

    private Direction randomMiddleDirection(Direction previous) {
        if (previous.isForward()) {
            return Direction.BACKWARD;
        }
        return randomDirection();
    }

    private Direction randomDirection() {
        Direction[] directions = {Direction.FORWARD, Direction.STAY};
        return directions[random.nextInt(directions.length)];
    }

    private Direction generateEndDirection(Direction previous) {
        if (previous.isForward()) {
            return Direction.BACKWARD;
        }
        return Direction.STAY;
    }

    private void adjustMiddleDirectionsIfAllDown(List<Direction> directions) {
        boolean allDown = directions.stream().allMatch(Direction::isStay);
        if (allDown) {
            adjustMiddleDirections(directions);
        }
    }

    private void adjustMiddleDirections(List<Direction> directions) {
        int index = randomMiddleIndex(directions.size());
        directions.set(index, Direction.FORWARD);
        directions.set(index + 1, Direction.BACKWARD);
    }

    private int randomMiddleIndex(int size) {
        return random.nextInt(size - START_END_COUNT) + FIRST_MIDDLE_INDEX;
    }
}
