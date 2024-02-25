package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<String> results, int playersCount) {
        validate(results.size(), playersCount);
        this.results = results.stream()
                .map(Result::new)
                .toList();
    }

    private void validate(int resultsCount, int playersCount) {
        if(resultsCount != playersCount) {
            throw new IllegalArgumentException("실행 결과의 수는 참가자의 수와 일치해야 합니다.");
        }
    }

    public List<Result> getResults() {
        return new ArrayList<>(results);
    }
}
