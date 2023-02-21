package domain;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = List.copyOf(results);
    }

    public List<Result> getResults() {
        return results;
    }
}
