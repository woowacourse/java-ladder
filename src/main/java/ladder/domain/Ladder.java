package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLevel> ladderLevels;
    private final Players players;

    public Ladder(Players players, Height height, DirectionGenerator directionGenerator) {
        ladderLevels = new ArrayList<>();
        this.players = players;
        IntStream.range(0, height.value())
                .forEach(i -> ladderLevels.add(new LadderLevel(players.count(), directionGenerator)));
    }

    public Stream<LadderLevel> stream() {
        return ladderLevels.stream();
    }

    public int findResultLocation(String name) {
        int currentLocation = players.getLocationByName(name);
        for (LadderLevel ladderLevel : ladderLevels) {
            currentLocation = ladderLevel
                    .move(currentLocation);
        }
        return currentLocation;
    }
}
