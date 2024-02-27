package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResults {
    private final Map<Player, Target> results;

    private LadderResults(Map<Player, Target> results) {
        this.results = results;
    }

    public static LadderResults of(Players players, Ladder ladder, Targets targets) {
        Map<Player, Target> results = new HashMap<>();
        for (Player player : players.getPlayers()) {
            results.put(player, targets.getPrize(ladder.climbLadder(players.getOrder(player))));
        }
        return new LadderResults(results);
    }

    public List<Target> getMatchingTargets(List<Player> players) {
        return players.stream().map(results::get).toList();
    }

    public Target getMatchingTarget(Player player) {
        return results.get(player);
    }
}
