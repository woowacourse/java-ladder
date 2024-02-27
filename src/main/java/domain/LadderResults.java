package domain;

import java.util.*;

public class LadderResults {
    private final Map<Player, Target> results;

    public LadderResults(final Map<Player, Target> results) {
        this.results = results;
    }

    public List<Target> getMatchingTargets(List<Player> players) {
        List<Target> matchingTargets = new ArrayList<>();
        for (Player player : players) {
            matchingTargets.add(results.get(player));
        }
        return Collections.unmodifiableList(matchingTargets);
    }
}
