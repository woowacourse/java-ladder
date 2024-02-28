package domain;

import java.util.List;

public class Results {

    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results of(List<String> results, int memberCount) {
        validateCount(results, memberCount);
        return new Results(results.stream()
                .map(Result::new)
                .toList());
    }

    private static void validateCount(List<String> results, int memberCount) {
        if (results.size() != memberCount) {
            throw new IllegalArgumentException("결과의 수는 참여자의 수와 같아야 합니다.");
        }
    }

    public Result findResultByPosition(int index) {
        return results.get(index);
    }

    public List<String> getValues() {
        return results.stream()
                .map(Result::getValue)
                .toList();
    }
}
