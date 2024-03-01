package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = new ArrayList<>(results);
    }

    public static Results from(final List<String> values) {
        final List<Result> results = values.stream()
                .map(Result::new)
                .toList();
        return new Results(results);
    }

    public int count() {
        return results.size();
    }

    public Result getBy(final int index) {
        return results.get(index);
    }

    public List<String> getValues() {
        return results.stream()
                .map(Result::value)
                .toList();
    }
}
