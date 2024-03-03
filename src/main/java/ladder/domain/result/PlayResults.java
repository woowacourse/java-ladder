package ladder.domain.result;

import ladder.domain.player.Name;

import java.util.Map;
import java.util.Set;

public class PlayResults {

    private final Map<Name, Result> value;

    public PlayResults(Map<Name, Result> value) {
        this.value = value;
    }

    public int size() {
        return value.size();
    }

    public Result find(Name name) {
        return value.get(name);
    }

    public Set<Name> getNames() {
        return value.keySet();
    }
}
