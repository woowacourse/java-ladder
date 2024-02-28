package ladder.domain;

import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LadderLevel {
    private final Map<Location, Direction> ladderLevel;
    private Direction latest;

    public LadderLevel(Width width, DirectionGenerator directionGenerator) {
        ladderLevel = new HashMap<>();
        latest = NONE;
        IntStream.range(0, width.value())
                .forEach((index) -> addDirection(new Location(index), directionGenerator));
        ladderLevel.replace(width.getLastLocation(), RIGHT, NONE);
    }

    public Location move(Location location) {
        return location.move(ladderLevel.get(location));
    }

    public List<Direction> getSortedDirections() {
        List<Direction> orderedDirections = new ArrayList<>();
        ladderLevel.forEach((location, direction) -> orderedDirections.add(location.value(), direction));
        return Collections.unmodifiableList(orderedDirections);
    }

    private void addDirection(Location location, DirectionGenerator directionGenerator) {
        latest = latest.next(directionGenerator);
        ladderLevel.put(location, latest);
    }
}
