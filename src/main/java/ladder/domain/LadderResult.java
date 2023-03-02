package ladder.domain;

import java.util.Collections;
import java.util.Map;

public class LadderResult {

    private final Map<String, String> value;

    public LadderResult(final Map<String, String> value) {
        this.value = value;
    }

    public String extract(final String key) {
        return value.get(key);
    }

    public boolean exist(final String key) {
        return value.containsKey(key);
    }

    public Map<String, String> getValue() {
        return Collections.unmodifiableMap(value);
    }
}
