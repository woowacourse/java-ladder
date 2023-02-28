package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(final String inputResult, final int numberOfName) {
        this.results = makeResults(inputResult, numberOfName);
    }

    private List<Result> makeResults(final String inputResult, final int numberOfName) {
        List<Result> results = Arrays.stream(inputResult.split(","))
                .map(Result::new)
                .collect(Collectors.toList());

        validateNumberOfResult(results.size(), numberOfName);

        return results;
    }

    private void validateNumberOfResult(final int resultsSize, final int numberOfName) {
        if (resultsSize != numberOfName) {
            throw new IllegalArgumentException("결과 값들의 개수는 입력된 이름의 개수와 같아야 합니다.");
        }
    }

    public List<Result> getResults() {
        return this.results;
    }
}
