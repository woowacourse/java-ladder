package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultsOfPlayers {
    private final Map<Player, Result> resultsOfPlayers;

    public ResultsOfPlayers(Players players, Ladder ladder, Results results) {
        resultsOfPlayers = new HashMap<>();
        initialize(players, ladder, results);
    }

    public Result getResultByName(String name) {
        Result result = resultsOfPlayers.get(new Player(new Name(name)));
        if (result == null) {
            throw new IllegalArgumentException("존재하지 않는 사용자입니다.");
        }
        return result;
    }

    public Map<Player, Result> getAllResults() {
        return Map.copyOf(resultsOfPlayers);
    }

    private void initialize(Players players, Ladder ladder, Results results) {
        List<Player> resultPlayers = new ArrayList<>();
        players.stream()
                .forEach(player -> resultPlayers.add(player.climb(ladder)));
        resultPlayers
                .forEach(player -> resultsOfPlayers.put(player, results.getResult(player.location())));
    }
}
