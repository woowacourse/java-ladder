package ladder.domain.result;

import java.util.Map;

import static java.util.Collections.unmodifiableMap;

public class GameResults {
    private final Map<String, String> values;

    public GameResults(final Map<String, String> values) {
        this.values = unmodifiableMap(values);
    }

    public String findByName(final String participantName) {
        if (!values.containsKey(participantName)) {
            throw new IllegalArgumentException("존재하지 않는 참가자입니다.");
        }
        return values.get(participantName);
    }

    public Map<String, String> getValues() {
        return values;
    }
}
