package ladder.domain;

import ladder.domain.strategy.linestrategy.Result;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<String> inputResults, int playerCount) {
        validateCount(inputResults.size(), playerCount);
        this.results = inputResults.stream()
                .map(inputResult -> new Result(inputResult))
                .collect(Collectors.toList());
    }

    private void validateCount(int resultCount, int playerCount) {
        if (resultCount != playerCount) {
            throw new IllegalArgumentException("[ERROR] 입력된 결과의 수가 인원 수와 다를 수 없습니다.");
        }
    }

}
