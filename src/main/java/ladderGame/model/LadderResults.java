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
}
