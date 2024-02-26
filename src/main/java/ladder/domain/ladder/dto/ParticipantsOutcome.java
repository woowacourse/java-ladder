package ladder.domain.ladder.dto;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;

public record ParticipantsOutcome(Map<String, String> values) {
    public ParticipantsOutcome {
        values = unmodifiableMap(new LinkedHashMap<>(values));
    }
}
