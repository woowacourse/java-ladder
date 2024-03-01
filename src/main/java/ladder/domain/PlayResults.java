package ladder.domain;

import java.util.Map;
import java.util.Set;

public class PlayResults {

    private final Map<Name, Result> value;

    PlayResults(Map<Name, Result> value) {
        this.value = value;
    }

    public int size() {
        return value.size();
    }

    public Result find(Name target) {
        return value.get(target);
    }

    public Set<Name> getNames() {
        return value.keySet();
    }
}
