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
            results.put(player.getName().getValue(), items.findBy(player.getPosition()).getName());
        }
        return new GameResult(results);
    }

    public Map<String, String> findResult(Name name) {
        if (!results.containsKey(name.getValue())) {
            throw new IllegalArgumentException("해당 이름의 결과를 찾을 수 없습니다");
        }
        return Map.of(name.getValue(), results.get(name.getValue()));
    }

    public Map<String, String> findAll() {
        return Collections.unmodifiableMap(results);
    }
}
