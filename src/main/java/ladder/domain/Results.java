package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results, int playerCount) {
        validatePlayerCount(results.size(), playerCount);
        this.results = results;
    }

    private void validatePlayerCount(int resultsCount, int playerCount) {
        if (resultsCount != playerCount) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 갯수와 참여할 사람이 같아야 합니다.");
        }
    }

    public int getResultsCount() {
        return results.size();
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
