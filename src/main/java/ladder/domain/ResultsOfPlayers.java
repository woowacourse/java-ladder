package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class ResultsOfPlayers {
    private final Map<Player, Result> rewardsOfPlayers;

    public ResultsOfPlayers(Players players, Ladder ladder, Results results) {
        rewardsOfPlayers = new HashMap<>();
        initialize(players, ladder, results);
    }

    public Result getResultByName(String name) {
        return rewardsOfPlayers.get(new Player(name));
    }

    public Map<Player, Result> getAllResults() {
        return Map.copyOf(rewardsOfPlayers);
    }

    private void initialize(Players players, Ladder ladder, Results results) {
        Map<Player, Location> resultPlayers = new HashMap<>();
        players.getSortedPlayers()
                .forEach(player -> resultPlayers.put(
                        player,
                        ladder.findResultLocation(players.getPlayerLocation(player))
                ));
        resultPlayers.forEach((player, location) -> rewardsOfPlayers.put(
                player,
                results.getResult(location)
        ));
    }
}
