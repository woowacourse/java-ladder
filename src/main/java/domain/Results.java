package domain;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<String> rawResult, int nameCount) {
        validateResultsCount(rawResult, nameCount);
        this.results = createResult(rawResult);
    }

    private List<Result> createResult(List<String> rawResults) {
        return rawResults.stream().map(Result::new).toList();
    }

    private void validateResultsCount(List<String> results, int nameCount) {
        if (results.size() != nameCount) {
            throw new IllegalArgumentException("실행 결과의 개수는 참가자 수와 동일해야 합니다.");
        }
    }
}
