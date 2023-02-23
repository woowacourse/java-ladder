package domain;

import java.util.List;
import java.util.stream.Collectors;
import utils.StringParser;

public class Results {

    private static final String RESULT_COUNT_ERROR = "[ERROR] 실행 결과 수는 사람 수와 같아야 합니다.";

    private final List<Result> results;

    public Results(final List<Result> results, final int userCount) {
        validate(results, userCount);
        this.results = List.copyOf(results);
    }

    private void validate(final List<Result> results, final int userCount) {
        if (results.size() != userCount) {
            throw new IllegalArgumentException(RESULT_COUNT_ERROR);
        }
    }

    public List<Result> getResults() {
        return results;
    }

    public List<String> getResultNames() {
        return results.stream()
                .map(result -> StringParser.insertBlank(result.getResultName()))
                .collect(Collectors.toUnmodifiableList());
    }
}
