package ladder.domain;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private final Map<String, String> results;

    private GameResult(Map<String, String> results) {
        this.results = results;
    }

    public static GameResult of(Players players, Items items) {
        Map<String, String> results = new LinkedHashMap<>();
        for (Player player : players.toUnmodifiablePlayers()) {
            results.put(player.getName(), items.findBy(player.getPosition()).getName());
        }
        return new GameResult(results);
    }

    public Map<String, String> findResult(String name) {
        if (name.equals("all")) {
            return findAll();
        }
        if (results.containsKey(name)) {
            return Map.of(name, results.get(name));
        }
        throw new IllegalArgumentException("해당 이름의 결과를 찾을 수 없습니다");
    }

    public Map<String, String> findAll() {
        return Collections.unmodifiableMap(results);
    }
}
