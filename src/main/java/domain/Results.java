package domain;

import exception.Error;

import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private final List<Result> results;

    public Results(List<String> results, int participantSize) {
        validate(results, participantSize);

        this.results = results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private void validate(List<String> results, int participantSize) {
        if (results.size() != participantSize) {
            throw new IllegalArgumentException(Error.INVALID_RESULTS_SIZE.getMessage());
        }
    }

    public String getResultByPosition(int position) {
        return results.get(position).getResult();
    }
}
