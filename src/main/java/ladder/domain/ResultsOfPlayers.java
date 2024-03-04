package ladder.domain;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.Map;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Result;
import ladder.domain.result.Results;

public class ResultsOfPlayers {
    private final Map<Player, Result> resultsOfPlayers;

    public ResultsOfPlayers(Players players, Results results) {
        resultsOfPlayers = players.stream()
                .collect(toMap(identity(), player -> results.getResult(player.location())));
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
