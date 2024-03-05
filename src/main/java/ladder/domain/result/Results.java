package ladder.domain.result;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Results {
    private List<Result> results;

    public Results(List<String> rawResults) {
        this.results = rawResults.stream()
                .map(Result::new)
                .collect(Collectors.toList());
    }

    public Results refactor(int size) {
        while (results.size() < size) {
            results.addAll(results);
        }
        if (results.size() > size) {
            results = results.subList(0, size);
        }
        return this;
    }

    public Result find(int position) {
        return results.get(position);
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }
}
