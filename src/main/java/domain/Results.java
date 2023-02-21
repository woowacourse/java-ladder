package domain;

import java.util.List;
import java.util.stream.Collectors;
import utils.StringParser;

public class Results {

    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = List.copyOf(results);
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
