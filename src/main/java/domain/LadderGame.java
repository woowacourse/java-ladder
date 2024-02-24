package domain;

import java.util.Collections;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final List<String> results;

    public LadderGame(List<String> userNames, int ladderHeight, List<String> results) {
        names = new Names(userNames);
        int nameCount = names.getNameCount();
        ladder = new Ladder(ladderHeight, nameCount, new BridgeRandomGenerator());
        this.results = Collections.unmodifiableList(results);
    }

    LadderGame(List<String> userNames, int ladderHeight, List<String> results, BridgeGenerator bridgeGenerator) {
        names = new Names(userNames);
        int nameCount = names.getNameCount();
        ladder = new Ladder(ladderHeight, nameCount, bridgeGenerator);
        this.results = Collections.unmodifiableList(results);
    }

    public List<String> getRawNames() {
        return names.getRawNames();
    }

    public List<List<Boolean>> getRawLadder() {
        return ladder.getRawLadder();
    }

    public List<String> getResults() {
        return results;
    }

    public String climb(String rawName) {
        int startPosition = names.position(rawName);
        int endPosition = ladder.climb(startPosition);
        return results.get(endPosition);
    }

    public List<String> climbAll() {
        return names.getRawNames().stream()
                .map(this::climb)
                .toList();
    }
}
