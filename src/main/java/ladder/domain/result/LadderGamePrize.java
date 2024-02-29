package ladder.domain.result;

import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.unmodifiableList;

public class LadderGamePrize {
    private final List<String> values;

    public LadderGamePrize(final List<String> values) {
        this.values = unmodifiableList(values);
    }

    public GameResults determinePersonalResult(final Participants participants) {
        final Map<String, String> results = new HashMap<>();
        for (final Participant participant: participants.getValues()) {
            final int position = participant.getPosition();
            final String prize = values.get(position);
            results.put(participant.getName(), prize);
        }
        return new GameResults(results);
    }

    public List<String> getValues() {
        return values;
    }
}
