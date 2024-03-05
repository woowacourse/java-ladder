package ladder.domain.result;

import ladder.domain.player.Name;

import java.util.Collections;
import java.util.Map;

public class PlayResults {

    private final Map<Name, Result> value;

    public PlayResults(Map<Name, Result> value) {
        this.value = value;
    }

    public Map<Name, Result> getValue() {
        return Collections.unmodifiableMap(value);
    }
}
