package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Result {

    private final LinkedHashMap<Player, ResultItem> matches;

    Result(Players players) {
        this.matches = new LinkedHashMap<>();
        players.getPlayers().forEach(name -> matches.put(name, null));
    }

    void put(Player player, ResultItem resultItem) {
        matches.put(player, resultItem);
    }

    Map<Player, ResultItem> get(Player player) {
        return Map.of(player, matches.get(player));
    }

    Map<Player, ResultItem> getAll() {
        return Collections.unmodifiableMap(matches);
    }

    boolean hasNullValue() {
        return matches.values().stream().anyMatch(Objects::isNull);
    }

    boolean hasNullValueForKey(Player player) {
        return matches.get(player) == null;
    }
}
