package ladder.domain;

import static ladder.domain.Direction.NONE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderLevel {
    private final List<Direction> ladderLevel;

    private Direction latest;

    public LadderLevel(int size, DirectionGenerator directionGenerator) {
        ladderLevel = new ArrayList<>();
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
            ladderLevel.remove(ladderLevel.size() - 1);
            ladderLevel.add(NONE);
        }
    }

    private Direction getDirectionOf(int location) {
        return ladderLevel.get(location);
    }
}
