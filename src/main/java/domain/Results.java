package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    private Results(List<Result> results, PlayerCount playerCount) {
        validate(results, playerCount);
        this.results = results;
    }

    public static Results from(List<String> results, PlayerCount playerCount) {
        return new Results(convertToResult(results), playerCount);
    }

    private void validate(List<Result> results, PlayerCount playerCount) {
        if (!playerCount.isSameWith(results.size())) {
            throw new IllegalArgumentException("참여자의 수와 실행 결과의 수가 일치하지 않습니다.");
        }
    }

    private static List<Result> convertToResult(List<String> results) {
        return results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }
}
