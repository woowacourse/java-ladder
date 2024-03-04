package laddergame.domain;

import static laddergame.domain.Player.NAME_BLANK_ERROR;

import java.util.List;

public class Results {
    private static final String COUNT_DIFFERENT_ERROR = "플레이어 수와 결과 수는 같아야 합니다. 입력된 플레이어 수: %d, 결과 수: %d ";
    private final List<Result> results;

    private Results(final List<Result> results) {
        this.results = results;
    }

    public static Results from(final List<String> resultNames, final int playerCount) {
        validate(resultNames, playerCount);
        return new Results(resultNames.stream()
                .map(Result::new)
                .toList()
        );
    }

    private static void validate(final List<String> resultNames, final int playerCount) {
        checkBlankName(resultNames);
        checkResultCounts(resultNames, playerCount);
    }

    private static void checkResultCounts(final List<String> resultNames, final int playerCount) {
        if (resultNames.size() != playerCount) {
            throw new IllegalArgumentException(String.format(COUNT_DIFFERENT_ERROR, playerCount, resultNames.size()));
        }
    }

    private static void checkBlankName(final List<String> resultNames) {
        if (resultNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }

    public List<Result> getResults() {
        return results;
    }
}
