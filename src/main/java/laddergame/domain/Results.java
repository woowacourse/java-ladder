package laddergame.domain;

import static laddergame.domain.Player.NAME_BLANK_ERROR;

import java.util.List;

public class Results {
    private final List<Result> results;

    private Results(final List<Result> results) {
        this.results = results;
    }

    public static Results from(final List<String> resultNames) {
        validate(resultNames);
        return new Results(resultNames.stream()
                .map(Result::new)
                .toList()
        );
    }

    private static void validate(final List<String> resultNames) {
        if (resultNames.stream().anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(NAME_BLANK_ERROR);
        }
    }

    public List<Result> getResults() {
        return results;
    }
}
