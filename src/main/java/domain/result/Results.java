package domain.result;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .toList();
    }

    public int size() {
        return results.size();
    }

    public Result get(int index) {
        return results.get(index);
    }

    public List<String> getRawResults() {
        return results.stream()
                .map(Result::rawResult)
                .toList();
    }
}
