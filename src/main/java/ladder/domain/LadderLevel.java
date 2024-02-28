package ladder.domain;

import static ladder.domain.Direction.NONE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LadderLevel {
    private final ArrayList<Direction> ladderLevel;

    public LadderLevel(Width width, DirectionGenerator directionGenerator) {
        ladderLevel = createLadderLevel(width, directionGenerator);
    }

    public int move(int index) {
        return index + ladderLevel.get(index).getMovement();
    }

    public List<Direction> getDirections() {
        return ladderLevel;
    }

    private ArrayList<Direction> createLadderLevel(Width width, DirectionGenerator directionGenerator) {
        LinkedList<Direction> directions = new LinkedList<>();
        Direction latest = NONE;
        while (width.isLargerThan(directions.size())) {
            latest = nextDirection(directionGenerator, latest);
            directions.add(latest);
        }
        changeInvalidLast(directions, latest);
        return new ArrayList<>(List.copyOf(directions));
    }

    private Direction nextDirection(DirectionGenerator directionGenerator, Direction latest) {
        latest = latest.next(directionGenerator);
        return latest;
    }

    private static void changeInvalidLast(LinkedList<Direction> directions, Direction latest) {
        if (latest.isInvalidLast()) {
            directions.removeLast();
            directions.add(NONE);
        }
    }
}
