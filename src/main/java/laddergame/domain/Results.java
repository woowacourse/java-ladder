package laddergame.domain;

import java.util.List;

public class Results {
    private final List<Result> results;

    private Results(final List<Result> results) {
        this.results = results;
    }

    public static Results from(final List<String> resultNames) {
        return new Results(resultNames.stream()
                .map(Result::new)
                .toList()
        );
    }

    public List<Result> getResults() {
        return results;
    }
}
