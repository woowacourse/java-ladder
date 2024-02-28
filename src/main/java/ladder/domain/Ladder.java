package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLevel> ladderLevels;

    public Ladder(Width width, Height height, DirectionGenerator directionGenerator) {
        ladderLevels = createLadderLevels(width, height, directionGenerator);
    }

    public Stream<LadderLevel> stream() {
        return ladderLevels.stream();
    }

    public Location findResultLocation(Location location) {
        int currentindex = location.value();
        for (LadderLevel ladderLevel : ladderLevels) {
            currentindex = ladderLevel.move(currentindex);
        }
        return new Location(currentindex);
    }

    private List<LadderLevel> createLadderLevels(Width width, Height height, DirectionGenerator directionGenerator) {
        LadderLevel[] ladderLevels = new LadderLevel[height.value()];
        Arrays.setAll(ladderLevels, ladderLevel -> new LadderLevel(width, directionGenerator));
        return Arrays.asList(ladderLevels);
    }
}
