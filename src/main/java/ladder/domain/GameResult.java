package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private final Map<Player, Item> results;

    private GameResult(Map<Player, Item> results) {
        this.results = results;
    }

    public static GameResult of(Players players, Items items) {
        Map<Player, Item> results = new LinkedHashMap<>();
        for (Player player : players.toUnmodifiablePlayers()) {
            results.put(player, items.findBy(player.getPosition()));
        }
        return new GameResult(results);
    }

    public Map<Player, Item> findResult(Player player) {
        if (results.containsKey(player)) {
            return Map.of(player, results.get(player));
        }
        throw new IllegalArgumentException("해당 이름의 결과를 찾을 수 없습니다");
    }

    public Map<Player, Item> findAll() {
        return Collections.unmodifiableMap(results);
    }
}
