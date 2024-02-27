package domain.result;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .toList();
    }

    public List<Result> getResults() {
        return results;
    }
}
