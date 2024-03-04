package ladder.domain.result;

import java.util.Collections;
import java.util.List;
import ladder.domain.player.Location;

public class Results {
    private final List<Result> results;

    public Results(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return Collections.unmodifiableList(results);
    }

    public Result getResult(Location location) {
        return results.get(location.value());
    }
}
