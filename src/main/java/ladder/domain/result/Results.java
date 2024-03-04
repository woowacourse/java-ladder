package ladder.domain.result;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<String> rawResults, int countStandard) {
        List<Result> results = rawResults.stream()
                .map(Result::new)
                .toList();
        validateCount(results, countStandard);
        this.results = results;
    }

    private void validateCount(List<Result> results, int countStandard) {
        if (results.size() != countStandard) {
            throw new IllegalArgumentException("결과 수가 올바르지 않습니다.");
        }
    }

    public Result find(int position) {
        return results.get(position);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
