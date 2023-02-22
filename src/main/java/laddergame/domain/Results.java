package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(final List<String> resultsNames, final int size) {
        validateResultsNumber(resultsNames, size);

        this.results = createResults(resultsNames);
    }

    private void validateResultsNumber(final List<String> resultsNames, final int size) {
        if (isDifferentSize(resultsNames, size)) {
            throw new IllegalArgumentException("실행 결과는 참여할 사람 수와 맞아야 합니다.");
        }
    }

    private static boolean isDifferentSize(final List<String> resultsNames, final int size) {
        return resultsNames.size() != size;
    }

    private List<Result> createResults(final List<String> resultsNames) {
        return resultsNames.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }
}
