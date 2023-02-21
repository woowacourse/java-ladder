package ladder.domain;

import java.util.List;

public class Result {

    private static final String COUNT_NOT_MATCH_MESSAGE = "[ERROR] 플레이어의 수와 결과의 수를 동일하게 입력하세요.";
    private static final String WRONG_RESULT_LENGTH_MESSAGE = "[ERROR] 각각의 실행 결과의 1자이상 5자이하로 입력하세요.";

    private static final int MAX_RESULT_LENGTH = 5;
    private static final int MIN_RESULT_LENGTH = 1;

    private final List<String> results;

    public Result(final List<String> results, final int playerNamesCount) {
        validate(results, playerNamesCount);
        this.results = List.copyOf(results);
    }

    private void validate(final List<String> results, final int playerNamesCount) {
        validateResultsCount(results, playerNamesCount);
        validateEachResultLength(results);
    }

    private void validateResultsCount(final List<String> results, final int playerNamesCount) {
        if (results.size() != playerNamesCount) {
            throw new IllegalArgumentException(COUNT_NOT_MATCH_MESSAGE);
        }
    }

    private void validateEachResultLength(final List<String> results) {
        long countOverMaxLength = results.stream()
                .filter((result) -> (result.length() > MAX_RESULT_LENGTH || result.length() < MIN_RESULT_LENGTH))
                .count();

        if (countOverMaxLength > 0) {
            throw new IllegalArgumentException(WRONG_RESULT_LENGTH_MESSAGE);
        }
    }

    public List<String> getResults() {
        return List.copyOf(results);
    }
}
