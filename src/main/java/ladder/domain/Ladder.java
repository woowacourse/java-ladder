package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLevel> ladderLevels;

    public Ladder(Width width, Height height, DirectionGenerator directionGenerator) {
        ladderLevels = new ArrayList<>();
        IntStream.range(0, height.value())
                .forEach(i -> ladderLevels.add(new LadderLevel(width, directionGenerator)));
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
}
