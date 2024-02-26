package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLevel {

    private final LinkedList<Direction> ladderLevel;

    private Direction last;

    public LadderLevel(int size, DirectionGenerator directionGenerator) {
        ladderLevel = new LinkedList<>();
        last = NONE;
        IntStream.range(0, size)
                .forEach((index) -> addDirection(directionGenerator));
        if (last == RIGHT) {
            ladderLevel.removeLast();
            ladderLevel.add(NONE);
        }
    }

    private void addDirection(DirectionGenerator directionGenerator) {
        if (last == RIGHT) {
            ladderLevel.add(LEFT);
            last = NONE;
            return;
        }
        Direction nextDirection = directionGenerator.generate();
        ladderLevel.add(nextDirection);
        last = nextDirection;
    }

    public Stream<Direction> stream() {
        return ladderLevel.stream();
    }

    public int move(int location) {
        return location + ladderLevel.get(location).getMovement();
    }
}
