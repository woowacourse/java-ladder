package laddergame.domain.result;

import java.util.List;
import laddergame.domain.ladder.Position;

public class Results {

    private final List<Result> results;

    public Results(final List<String> results) {
        this.results = results.stream()
                .map(Result::new)
                .toList();
    }

    public int size() {
        return results.size();
    }

    public Result get(final Position resultPosition) {
        return results.get(resultPosition.getPosition());
    }

    public List<Result> getResults() {
        return results;
    }
}
