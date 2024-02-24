package domain;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final Results results;

    public LadderGame(List<String> userNames, int ladderHeight, List<String> rawResults) {
        names = new Names(userNames);
        int nameCount = names.getNameCount();
        ladder = new Ladder(ladderHeight, nameCount, new BridgeRandomGenerator());
        this.results = new Results(rawResults);
    }

    LadderGame(List<String> userNames, int ladderHeight, List<String> rawResults, BridgeGenerator bridgeGenerator) {
        names = new Names(userNames);
        int nameCount = names.getNameCount();
        ladder = new Ladder(ladderHeight, nameCount, bridgeGenerator);
        this.results = new Results(rawResults);
    }

    public List<String> getRawNames() {
        return names.getRawNames();
    }

    public List<List<Boolean>> getRawLadder() {
        return ladder.getRawLadder();
    }

    public List<String> getRawResults() {
        return results.getRawResults();
    }

    public List<String> showClimbResults(String rawOperator) {
        LadderGameOperator operator = new LadderGameOperator(rawOperator);
        if (operator.isAll()) {
            return climbAll();
        }
        return List.of(climb(rawOperator));
    }

    private List<String> climbAll() {
        return names.getRawNames().stream()
                .map(this::climb)
                .toList();
    }

    private String climb(String rawName) {
        int startPosition = names.position(rawName);
        int endPosition = ladder.climb(startPosition);
        return results.getRawResult(endPosition);
    }
}
