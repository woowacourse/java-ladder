package ladder.domain;

import static ladder.domain.Direction.NONE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderLevel {
    private final List<Direction> ladderLevel;
    private Direction latest;

    public LadderLevel(Width width, DirectionGenerator directionGenerator) {
        latest = NONE;
        ladderLevel = new ArrayList<>(width.repeat(() -> nextDirection(directionGenerator)));
        changeInvalidLast();
    }

    public Location move(Location location) {
        return location.move(getDirection(location));
    }

    private Direction getDirection(Location location) {
        return ladderLevel.get(location.value());
    }

    public List<Direction> getDirections() {
        return Collections.unmodifiableList(ladderLevel);
    }

    private Direction nextDirection(DirectionGenerator directionGenerator) {
        latest = latest.next(directionGenerator);
        return latest;
    }

    private void changeInvalidLast() {
        if (latest.isInvalidLast()) {
            ladderLevel.remove(ladderLevel.lastIndexOf(latest));
            ladderLevel.add(NONE);
        }
    }
}
