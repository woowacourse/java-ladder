package domain;

import java.util.List;

public class LadderResults {
    private static final int MIN_LADDER_RESULTS_LENGTH = 2;
    private static final int MAX_LADDER_RESULTS_LENGTH = 10;

    private final List<LadderResult> ladderResults;

    public LadderResults(List<LadderResult> ladderResults) {
        validateLadderResultsLength(ladderResults);
        this.ladderResults = ladderResults;
    }

    private void validateLadderResultsLength(List<LadderResult> ladderResults) {
        if (ladderResults.size() < MIN_LADDER_RESULTS_LENGTH || ladderResults.size() > MAX_LADDER_RESULTS_LENGTH) {
            throw new LadderGameException(ExceptionType.INVALID_LADDER_RESULTS_RANGE);
        }
    }

    public List<LadderResult> getLadderResults() {
        return ladderResults;
    }
}
