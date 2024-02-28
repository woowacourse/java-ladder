package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Players {
    private static final int MIN_PLAYERS_COUNT = 2;
    private final Map<Player, Location> playersAndLocations;

    public Players(List<String> names) {
        validate(names);
        playersAndLocations = new HashMap<>();
        IntStream.range(0, names.size())
                .forEach(index -> playersAndLocations.put(new Player(names.get(index)), new Location(index)));
    }

    public int count() {
        return playersAndLocations.size();
    }

    public Location getPlayerLocation(Player player) {
        return playersAndLocations.get(player);
    }

    public List<Player> getSortedPlayers() {
        List<Player> sortedPlayers = new ArrayList<>();
        playersAndLocations.forEach((player, location) -> sortedPlayers.add(location.value(), player));
        return Collections.unmodifiableList(sortedPlayers);
    }

    private void validate(List<String> names) {
        validatePlayersCount(names);
        validateDuplicatedName(names);
    }

    private void validatePlayersCount(List<String> names) {
        if (names.size() < MIN_PLAYERS_COUNT) {
            throw new IllegalArgumentException(
                    "참여자는 최소 %d명입니다.".formatted(MIN_PLAYERS_COUNT)
            );
        }
    }

    private void validateDuplicatedName(List<String> names) {
        List<String> distinctNames = new ArrayList<>();
        names.forEach(name -> {
            throwExceptionIfContains(distinctNames, name);
            distinctNames.add(name);
        });
    }

    private static void throwExceptionIfContains(List<String> distinctNames, String name) {
        if (distinctNames.contains(name)) {
            throw new IllegalArgumentException(
                    "중복된 이름은 입력할 수 없습니다: %s".formatted(name)
            );
        }
    }
}
