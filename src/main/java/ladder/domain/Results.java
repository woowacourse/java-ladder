package ladder.domain;

import java.util.List;

public class Results {
    private final List<String> results;

    public Results(List<String> results) {
        this.results = results;
    }

    public String find(int position) {
        return results.get(position);
    }
}
