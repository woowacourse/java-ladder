package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import domain.Result;

public class Results {

    private final List<Result> results;

    public Results(final String inputResult, final int numberOfName) {
        List<Result> results = makeResults(inputResult);
        validateNumberOfResults(results.size(), numberOfName);
        this.results = results;
    }

    private List<Result> makeResults(final String inputResult) {
        return Arrays.stream(inputResult.split(","))
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private void validateNumberOfResults(final int resultsSize, final int numberOfName) {
        if (resultsSize != numberOfName) {
            throw new IllegalArgumentException("결과 값들의 개수는 입력된 이름의 개수와 같아야 합니다.");
        }
    }

    public List<Result> getResults() {
        return this.results;
    }
}
