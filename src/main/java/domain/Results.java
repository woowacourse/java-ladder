package domain;

import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .toList();
    }

    public List<String> getRawResults() {
        return results.stream()
                .map(Result::rawResult)
                .toList();
    }

    public String getRawResult(int position) {
        List<String> rawResults = getRawResults();
        return rawResults.get(position);
    }
}
