package ladder.domain;

import java.util.Map;
import java.util.Set;

public class PlayResults {

    private final Map<Target, Result> value;

    PlayResults(Map<Target, Result> value) {
        this.value = value;
    }

    public int size() {
        return value.size();
    }

    public Result find(Target target) {
        return value.get(target);
    }

    public Set<Target> getNames() {
        return value.keySet();
    }
}
