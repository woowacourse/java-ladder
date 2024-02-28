package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Results {
    private final List<Result> results;

    public Results(List<String> results) {
        this.results = new ArrayList<>();
        IntStream.range(0, results.size())
                .forEach(index -> this.results.add(new Result(results.get(index))));
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public Result getResult(Location location) {
        return results.get(location.value());
    }
}
