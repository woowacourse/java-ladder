package ladder.domain;

import static ladder.domain.Direction.NONE;

import java.util.LinkedList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLevel {

    private final LinkedList<Direction> ladderLevel;

    private Direction latest;

    public LadderLevel(int size, DirectionGenerator directionGenerator) {
        ladderLevel = new LinkedList<>();
        latest = NONE;
        IntStream.range(0, size)
                .forEach((index) -> addDirection(directionGenerator));
        replaceLast();
    }

    public Stream<Direction> stream() {
        return ladderLevel.stream();
    }

    public int move(int location) {
        return location + getDirectionOf(location).getMovement();
    }

    private void addDirection(DirectionGenerator directionGenerator) {
        latest = latest.next(directionGenerator);
        ladderLevel.add(latest);
    }

    private void replaceLast() {
        if (latest.isInvalidLastDirection()) {
            ladderLevel.removeLast();
            ladderLevel.add(NONE);
        }
    }

    private Direction getDirectionOf(int location) {
        return ladderLevel.get(location);
    }
}
