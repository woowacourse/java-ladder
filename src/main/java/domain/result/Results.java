package domain.result;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<String> results, int playerCount) {
        validateResultCount(results, playerCount);
        this.results = results.stream()
                .map(Result::new)
                .toList();
    }

    private void validateResultCount(List<String> results, int playerCount) {
        if (results.size() != playerCount) {
            throw new IllegalArgumentException("실행 결과의 수는 사용자들의 수와 동일해야 합니다.");
        }
    }

    public List<Result> getResults() {
        return results;
    }
}
