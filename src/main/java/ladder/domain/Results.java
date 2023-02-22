package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<Result> results;

    public Results(final List<Result> results) {
        this.results = new ArrayList<>(results);
    }
}
