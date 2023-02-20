package ladder.domain;

import java.util.List;

public class Result {

    public static final String COUNT_NOT_MATCH_MESSAGE = "[ERROR] 플레이어의 수와 결과의 수를 동일하게 입력하세요.";

    private final List<String> results;

    public Result(List<String> results, int playerNamesCount) {
        validate(results, playerNamesCount);
        this.results = List.copyOf(results);
    }

    private void validate(List<String> results, int playerNamesCount) {
        if(results.size() != playerNamesCount) {
            throw new IllegalArgumentException(COUNT_NOT_MATCH_MESSAGE);
        }
    }

    public List<String> getResults() {
        return List.copyOf(results);
    }
}
