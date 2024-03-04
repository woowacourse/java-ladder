package ladder.domain.ladder;

import java.util.List;
import java.util.stream.Stream;
import ladder.domain.DirectionGenerator;
import ladder.domain.player.Location;

public class Ladder {
    private final List<LadderLevel> ladderLevels;

    public Ladder(Width width, Height height, DirectionGenerator directionGenerator) {
        ladderLevels = height.repeat(() -> new LadderLevel(width, directionGenerator));
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
