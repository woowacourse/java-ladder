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
        final Map<Participant, Integer> participantsWitPosition = participants.getParticipantsWitPosition();
        for (final Map.Entry<Participant, Integer> participantWithPosition: participantsWitPosition.entrySet()) {
            final Participant participant = participantWithPosition.getKey();
            final int position = participantWithPosition.getValue();
            final String prize = values.get(position);
            results.put(participant.getName(), prize);
        }
        return new GameResults(results);
    }

    public List<String> getValues() {
        return values;
    }
}
