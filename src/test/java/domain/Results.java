package domain;

import java.util.ArrayList;
import java.util.List;

public class Results {

    private final List<String> results;

    public Results(final List<String> results) {
        this.results = new ArrayList<>(results);
    }
}
