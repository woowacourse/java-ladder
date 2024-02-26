package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LadderResults {
    private final HashMap<Player, Target> results;

    public LadderResults(HashMap<Player, Target> results) {
        this.results = results;
    }

    public List<Target> getMatchingTargets(List<Player> players) {
        List<Target> matchingTargets = new ArrayList<>();
        for (Player player : players) {
            matchingTargets.add(results.get(player));
        }
        return matchingTargets;
    }
}
