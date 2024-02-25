package domain;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(final List<String> values) {
        this.results = values.stream()
                .map(Result::new)
                .toList();
    }

    public List<String> getAll() {
        return results.stream()
                .map(Result::getValue)
                .toList();
    }

    public String resultOf(final int index) {
        return results.get(index).getValue();
    }
}
