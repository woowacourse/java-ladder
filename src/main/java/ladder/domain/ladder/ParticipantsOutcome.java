package ladder.domain.ladder;

import ladder.exception.participant.NoSuchParticipantException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Collections.unmodifiableMap;

public class ParticipantsOutcome {

    private final Map<String, String> values;

    public ParticipantsOutcome(Map<String, String> values) {
        this.values = unmodifiableMap(new LinkedHashMap<>(values));
    }

    public String getOutcome(String participantName) {
        return Optional.ofNullable(values.get(participantName))
                .orElseThrow(NoSuchParticipantException::new);
    }

    public Map<String, String> getValues() {
        return values;
    }
}
