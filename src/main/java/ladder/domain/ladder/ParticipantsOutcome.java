package ladder.domain.ladder;

import ladder.exception.participant.NoSuchParticipantException;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static java.util.Collections.unmodifiableMap;

public class ParticipantsOutcome {
    private static final String ALL = "all";

    private final Map<String, String> values;

    public ParticipantsOutcome(Map<String, String> values) {
        this.values = unmodifiableMap(new LinkedHashMap<>(values));
    }

    public boolean allOutcomesRequired(final String input) {
        return ALL.equals(input);
    }

    public String getOutcome(String participantName) {
        return Optional.ofNullable(values.get(participantName))
                .orElseThrow(NoSuchParticipantException::new);
    }

    public Map<String, String> getValues() {
        return values;
    }
}
