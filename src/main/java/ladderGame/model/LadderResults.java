package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class LadderResults {
    private final List<LadderResult> ladderResults;

    public LadderResults(List<String> results) {
        ladderResults = new ArrayList<>();
        for (String result : results) {
            ladderResults.add(new LadderResult(result));
        }
    }

    public LadderResult getLadderResult(int index) {
        return ladderResults.get(index);
    }

    public List<LadderResult> getLadderResults() {
        return new ArrayList<>(ladderResults);
    }
}
