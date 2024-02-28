package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Results {
    private final Map<Location, Result> results;

    public Results(List<String> results) {
        this.results = new HashMap<>();
        IntStream.range(0, results.size())
                .forEach(index -> this.results.put(new Location(index), new Result(results.get(index))));
    }

    public Result getResult(Location location) {
        return results.get(location);
    }

    public List<Result> getSortedResults() {
        List<Result> orderedResults = new ArrayList<>();
        results.forEach((location, result) -> orderedResults.add(location.value(), result));
        return Collections.unmodifiableList(orderedResults);
    }
}
