package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import ladder.error.ErrorMessage;

public class Results {
    public List<Result> getResults() {
        return results;
    }

    private final List<Result> results;

    public Results(List<String> results, int numberOfResults) {
        validate(results, numberOfResults);

        this.results = results.stream()
            .map(Result::new)
            .collect(Collectors.toList());
    }

    private void validate(List<String> names, int numberOfResults) {
        validateNumberOfResults(names, numberOfResults);
    }

    private void validateNumberOfResults(List<String> names, int numberOfResults) {
        if (names.size() < numberOfResults || names.size() > numberOfResults) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_OF_RESULTS.getMessage());
        }
    }
}
