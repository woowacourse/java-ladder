package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class GameResult {
    private final Map<String, String> results;

    private GameResult(Map<String, String> results) {
        this.results = results;
    }

    public static GameResult generate(Players players, Items items) {
        Map<String, String> results = new HashMap<>();
        for (Player player : players.toUnmodifiablePlayers()) {
            results.put(player.getName().getValue(), items.findBy(player.getPosition()).getName());
        }
        return new GameResult(results);
    }

    public Map<String, String> findResult(Name name) {
        return Map.of(name.getValue(), results.get(name.getValue()));
    }
}
