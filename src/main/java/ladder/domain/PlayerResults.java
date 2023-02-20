package ladder.domain;

import static java.util.stream.Collectors.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PlayerResults {
    private final Map<Player, Result> playerResults;

    public PlayerResults(List<Player> players, List<Result> results) {
        this.playerResults = IntStream.range(0, players.size())
                .boxed()
                .collect(toMap(players::get, results::get));
    }

    public Result getResultByPlayer(Player player) {
        return playerResults.get(player);
    }

    public Map<Player, Result> getPlayerResults() {
        return Collections.unmodifiableMap(playerResults);
    }
}
