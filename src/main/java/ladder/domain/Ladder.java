package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLevel> ladderLevels;

    public Ladder(Width width, Height height, DirectionGenerator directionGenerator) {
        ladderLevels = new ArrayList<>();
        height.repeat(() -> ladderLevels.add(new LadderLevel(width, directionGenerator)));
    }

    public Stream<LadderLevel> stream() {
        return ladderLevels.stream();
    }

    public Location findResultLocation(Location location) {
        Location resultLocation = location;
        for (LadderLevel ladderLevel : ladderLevels) {
            resultLocation = ladderLevel.move(resultLocation);
        }
        return resultLocation;
    }
}
