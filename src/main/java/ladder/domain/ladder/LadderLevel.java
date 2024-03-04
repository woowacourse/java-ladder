package ladder.domain.ladder;

import static java.util.stream.Collectors.toMap;
import static ladder.domain.ladder.Direction.NONE;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import ladder.domain.DirectionGenerator;
import ladder.domain.player.Location;

public class LadderLevel {
    private final Map<Location, Direction> ladderLevel;
    private Direction latest;

    public LadderLevel(Width width, DirectionGenerator directionGenerator) {
        latest = NONE;
        LinkedList<Direction> directions = new LinkedList<>(width.repeat(() -> nextDirection(directionGenerator)));
        changeInvalidLast(directions);
        ladderLevel = new LinkedHashMap<>(IntStream.range(0, directions.size())
                .boxed()
                .collect(toMap(Location::new, directions::get)));
    }

    public Location move(Location location) {
        return location.move(getDirection(location));
    }

    private Direction getDirection(Location location) {
        return ladderLevel.get(location);
    }

    public List<Direction> getDirections() {
        return ladderLevel.values().stream().toList();
    }

    private Direction nextDirection(DirectionGenerator directionGenerator) {
        latest = latest.next(directionGenerator);
        return latest;
    }

    private void changeInvalidLast(LinkedList<Direction> directions) {
        if (latest.isInvalidLast()) {
            directions.removeLast();
            directions.add(NONE);
        }
    }
}
