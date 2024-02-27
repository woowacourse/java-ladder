package domain;

import java.util.List;
import java.util.Map;

public class LadderResults {
    private final Map<Player, Target> results;

    public LadderResults(final Map<Player, Target> results) {
        this.results = results;
    }

    public List<Target> getMatchingTargets(List<Player> players) {
        return players.stream().map(results::get).toList();
    }
}
