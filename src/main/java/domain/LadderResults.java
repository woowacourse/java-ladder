package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LadderResults {
    private final HashMap<Player, Target> results;

    public LadderResults(HashMap<Player, Target> results) {
        this.results = results;
    }

    public List<Target> getMatchingTarget(List<Player> players) {
        List<Target> matchingTargets = new ArrayList<>();
        for (Player player : players) {
            validateContain(player);
            matchingTargets.add(results.get(player));
        }
        return matchingTargets;
    }

    private void validateContain(Player player) {
        if (!results.containsKey(player)) {
            throw new IllegalArgumentException("해당 참여자는 리스트에 없습니다.");
        }
    }
}
