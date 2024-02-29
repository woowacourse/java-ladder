package result;

import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(List<String> resultNames) {
        this.results = resultNames.stream()
                .map(Result::new)
                .toList();
    }

    public List<String> getNames() {
        return results.stream()
                .map(Result::getName)
                .toList();
    }

    public int size() {
        return results.size();
    }
}
