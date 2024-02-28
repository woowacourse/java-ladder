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
                .forEach(i -> ladderLevels.add(new LadderLevel(width.value(), directionGenerator)));
    }

    public Stream<LadderLevel> stream() {
        return ladderLevels.stream();
    }

    public List<Player> findAllResultPlayers(Players players) {
        List<Player> resultPlayers = new ArrayList<>();
        players.stream()
                .forEach(player ->
                        resultPlayers.add(new Player(player.name(), findResultLocation(player)))
                );
        return resultPlayers;
    }

    private int findResultLocation(Player player) {
        int currentLocation = player.location();
        for (LadderLevel ladderLevel : ladderLevels) {
            currentLocation = ladderLevel.move(currentLocation);
        }
        return currentLocation;
    }
}
