package ladder.domain.result;

import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class LadderGamePrize {
    private final List<String> values;

    public LadderGamePrize(final List<String> values) {
        this.values = unmodifiableList(values);
    }

    public GameResults determinePersonalResult(final Participants participants) {
        final List<PersonalGameResult> results = new ArrayList<>();
        for (final Participant participant: participants.getValues()) {
            final int position = participant.getPosition();
            final String prize = values.get(position);
            results.add(new PersonalGameResult(participant, prize));
        }
        return new GameResults(results);
    }

    public List<String> getValues() {
        return values;
    }
}
