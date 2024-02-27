package domain;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<Result> results, int memberCount) {
        validateCount(results, memberCount);
        this.results = results;
    }

    private void validateCount(List<Result> results, int memberCount) {
        if (results.size() != memberCount) {
            throw new IllegalArgumentException("결과의 수는 참여자의 수와 같아야 합니다.");
        }
    }
}
