package domain.model;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    public Results(final List<String> values) {
        this.results = makeResults(values);
    }

    private List<Result> makeResults(final List<String> values) {
        return values.stream()
            .map(Result::new)
            .collect(Collectors.toUnmodifiableList());
    }

    public List<Result> getResults() {
        return results;
    }
}
