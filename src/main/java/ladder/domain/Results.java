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

    public Result findResultByIndex(int index) {
        if (isProperIndex(index)) {
            throw new IllegalArgumentException("[ERROR] 인덱스 범위를 초과했습니다.");
        }
        return results.get(index);
    }

    private boolean isProperIndex(int index) {
        return index < 0 || index >= results.size();
    }

    public int getResultsCount() {
        return results.size();
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
