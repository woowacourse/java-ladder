package ladder.domain.participant;

import ladder.domain.participant.Participant;
import ladder.exception.DelimiterBoundaryException;

import java.util.Arrays;
import java.util.List;

public class Participants {
    private static final String DELIMITER = ",";

    private final List<Participant> participants;

    public Participants(String names) {
        validate(names);
        this.participants = convertToParticipants(names);
    }

    private void validate(final String names) {
        if (names.startsWith(DELIMITER) || names.endsWith(DELIMITER)) {
            throw new DelimiterBoundaryException();
        }
    }

    private List<Participant> convertToParticipants(final String names) {
        return Arrays.stream(names.split(DELIMITER))
                .map(Participant::new)
                .toList();
    }

    public int getCount() {
        return participants.size();
    }

    public List<Participant> getValues() {
        return participants;
    }
}
