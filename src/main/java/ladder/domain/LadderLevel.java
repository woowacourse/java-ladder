package ladder.domain;

import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class LadderLevel {
    private final LinkedList<Direction> ladderLevel;
    private Direction latest;

    public LadderLevel(Width width, DirectionGenerator directionGenerator) {
        ladderLevel = new LinkedList<>();
        latest = NONE;
        IntStream.range(0, width.value())
                .forEach((index) -> addDirection(directionGenerator));
        if (latest == RIGHT) {
            ladderLevel.removeLast();
            ladderLevel.add(NONE);
        }
    }

    public int move(int index) {
        return index + ladderLevel.get(index).getMovement();
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(ladderLevel);
    }

    private void addDirection(DirectionGenerator directionGenerator) {
        latest = latest.next(directionGenerator);
        ladderLevel.add(latest);
    }
}
