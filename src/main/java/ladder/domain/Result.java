package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Result {

    private final LinkedHashMap<Player, ResultItem> matches;

    public Result(Players players) {
        this.matches = new LinkedHashMap<>();
        players.getPlayers().forEach(name -> matches.put(name, null));
    }

    public void put(Player player, ResultItem resultItem) {
        matches.put(player, resultItem);
    }

    public Map<Player, ResultItem> get(Player player) {
        return Map.of(player, matches.get(player));
    }

    public Map<Player, ResultItem> getAll() {
        return Collections.unmodifiableMap(matches);
    }

    public boolean hasNullValue() {
        return matches.values().stream().anyMatch(Objects::isNull);
    }

    public boolean hasNullValueForKey(Player player) {
        return matches.get(player) == null;
    }
}
