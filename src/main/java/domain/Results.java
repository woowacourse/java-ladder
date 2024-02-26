package domain;

import java.util.Collections;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
