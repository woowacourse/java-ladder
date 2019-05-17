package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class EndResult {
    private final List<Result> results;

    public EndResult(List<Result> results) {
        this.results = results;
    }

    public Result getMemberResult(String member) {
        for (Result result : results) {
            if (result.getWinner().equals(member)) {
                return result;
            }
        }
        throw new IllegalArgumentException();
    }

    public List<Result> getAllResult() {
        return new ArrayList<>(results);
    }
}
