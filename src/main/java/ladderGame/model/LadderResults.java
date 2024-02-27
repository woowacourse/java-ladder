package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class LadderResults {
    private final List<LadderResult> ladderResults;

    public LadderResults(List<String> results) {
        ladderResults = results.stream().map(LadderResult::new).toList();
    }

    public int getLadderResultsSize() {
        return ladderResults.size();
    }

    public LadderResult getLadderResult(int index) {
        return ladderResults.get(index);
    }

    public List<LadderResult> getLadderResults() {
        return new ArrayList<>(ladderResults);
    }
}
