package laddergame.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Results {
    private static final int MIN_RESULTS_SIZE = 2;
    private static final String RESULTS_EMPTY_EXCEPTION = "Results는 비어있을 수 없습니다.";
    private static final String RESULTS_NAMES_NOT_SAME_SIZE_EXCEPTION ="결과 목록과 이름 목록 개수가 동일해야 합니다.";

    private final List<Result> results;

    public Results(final List<String> inputResults, final Names names) {
        final List<String> results = getResults(inputResults);
        validateResults(results, names);
        this.results = createResults(results);
    }

    public Result findResultByPosition(final Position position) {
        return results.get(position.getValue());
    }

    public List<String> getResults() {
        return results.stream()
                .map(Result::getValue)
                .collect(Collectors.toList());
    }

    private List<Result> createResults(final List<String> results) {
        return results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    private List<String> getResults(final List<String> inputResults) {
        return Optional.ofNullable(inputResults).orElse(List.of());
    }

    private void validateResults(final List<String> results, final Names names) {
        if (results.size() < MIN_RESULTS_SIZE) {
            throw new IllegalArgumentException(RESULTS_EMPTY_EXCEPTION);
        }
        if (results.size() != names.getSize()) {
            throw new IllegalArgumentException(RESULTS_NAMES_NOT_SAME_SIZE_EXCEPTION);
        }
    }
}
