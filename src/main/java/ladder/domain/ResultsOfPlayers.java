package ladder.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResultsOfPlayers {
    private final Map<Player, Result> resultsOfPlayers;

    public ResultsOfPlayers(Players players, Results results) {
        resultsOfPlayers = new HashMap<>();
        initialize(players, results);
    }

    private void initialize(Players players, Results results) {
        players.stream()
                .forEach(player -> resultsOfPlayers.put(player, results.getResult(player.location())));
    }

    public Result getResultByName(String name) {
        Result result = resultsOfPlayers.get(new Player(new Name(name)));
        if (result == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다: %s".formatted(name));
        }
        return result;
    }

    public Map<Player, Result> getResultsOfPlayers() {
        return Collections.unmodifiableMap(resultsOfPlayers);
    }
}
