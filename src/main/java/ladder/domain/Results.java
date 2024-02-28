package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Results {
    private final List<Result> results;

    public Results(List<String> results) {
        this.results = new ArrayList<>();
        results.forEach(result -> this.results.add(new Result(result)));
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public Result getResult(Location location) {
        return results.get(location.value());
    }
}
