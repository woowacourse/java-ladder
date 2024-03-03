package domain.result;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import java.util.List;

public class Results {
    private static final int MIN_LADDER_RESULTS_LENGTH = 2;
    private static final int MAX_LADDER_RESULTS_LENGTH = 10;
    private final List<Result> results;

    public Results(List<Result> results) {
        validateLadderResultsLength(results);
        this.results = results;
    }

    private void validateLadderResultsLength(List<Result> results) {
        if (results.size() < MIN_LADDER_RESULTS_LENGTH || results.size() > MAX_LADDER_RESULTS_LENGTH) {
            throw new LadderGameException(ExceptionType.INVALID_LADDER_RESULTS_RANGE);
        }
    }

    public int count() {
        return results.size();
    }

    public List<Result> getLadderResults() {
        return results;
    }
}
