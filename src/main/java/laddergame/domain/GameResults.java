package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static laddergame.utils.OptionalUtils.getValueAfterNullCheck;

public class GameResults {
    private static final int MIN_RESULTS_SIZE = 2;
    private static final int MIN_RESULT_LENGTH = 0;
    private static final String RESULTS_EMPTY_EXCEPTION = "Results는 비어있을 수 없습니다.";
    private static final String RESULTS_NAMES_NOT_SAME_SIZE_EXCEPTION ="결과 목록과 이름 목록 개수가 동일해야 합니다.";

    private final List<Result> results;

    public GameResults(final List<String> inputResults, final Names names) {
        final List<String> results = getValueAfterNullCheck(inputResults);
        validateResults(results, names);
        this.results = createResults(results);
    }

    public Result findResultByPosition(final Position position) {
        return results.get(position.getValue());
    }

    public int getMaxResultLength() {
        return results.stream()
                .map(Result::getValue)
                .mapToInt(String::length)
                .max()
                .orElse(MIN_RESULT_LENGTH);
    }

    public List<Result> getResults() {
        return new ArrayList<>(results);
    }

    public List<String> getResultValues() {
        return results.stream()
                .map(Result::getValue)
                .collect(Collectors.toList());
    }

    private List<Result> createResults(final List<String> results) {
        return results.stream()
                .map(Result::new)
                .collect(Collectors.toList());
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
