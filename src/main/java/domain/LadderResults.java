package domain;

import java.util.Iterator;
import java.util.List;

public class LadderResults implements Iterable<LadderResult> {

    private final List<LadderResult> results;

    public LadderResults(List<LadderResult> results) {
        this.results = results;
    }

    public LadderResult getSingleResult() {
        return results.get(0);
    }

    @Override
    public Iterator<LadderResult> iterator() {
        return results.iterator();
    }

    public boolean isSingleResult() {
        return results.size() == 1;
    }
}
