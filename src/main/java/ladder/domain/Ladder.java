package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ladder {
    private final List<LadderLevel> ladderLevels;
    private final List<Player> resultPlayers;

    public Ladder(Players players, Height height, DirectionGenerator directionGenerator) {
        ladderLevels = new ArrayList<>();
        resultPlayers = new ArrayList<>();
        IntStream.range(0, height.value())
                .forEach(i -> ladderLevels.add(new LadderLevel(players.count(), directionGenerator)));
        findAllResultLocation(players);
    }

    public Stream<LadderLevel> stream() {
        return ladderLevels.stream();
    }

    private void findAllResultLocation(Players players) {
        players.stream()
                .forEach(player ->
                        resultPlayers.add(new Player(player.name(), findResultLocation(player)))
                );
    }

    private int findResultLocation(Player player) {
        int currentLocation = player.location();
        for (LadderLevel ladderLevel : ladderLevels) {
            currentLocation = ladderLevel.move(currentLocation);
        }
        return currentLocation;
    }

    public List<Player> getAllResultLocation() {
        return List.copyOf(resultPlayers);
    }

    public int getResultLocation(String name) {
        return resultPlayers.stream()
                .filter(player -> player.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이름입니다."))
                .location();
    }
}
