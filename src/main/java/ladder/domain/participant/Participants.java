package ladder.domain.participant;

import ladder.exception.participant.DuplicatedNamesException;
import ladder.exception.participant.InvalidParticipantsCountException;

import java.util.List;
import java.util.Set;

public class Participants {
    private static final int MIN_PARTICIPANTS_COUNT = 2;

    private final List<Participant> participants;

    public Participants(final List<String> names) {
        validateParticipantsCount(names);
        validateDuplicatedNames(names);
        this.participants = names.stream()
                .map(Participant::new)
                .toList();
    }

    private void validateParticipantsCount(final List<String> names) {
        if (names.size() < MIN_PARTICIPANTS_COUNT) {
            throw new InvalidParticipantsCountException();
        }
    }

    private void validateDuplicatedNames(final List<String> names) {
        final Set<String> uniqueNames = Set.copyOf(names);
        if (uniqueNames.size() < names.size()) {
            throw new DuplicatedNamesException();
        }
    }

    public int getNecessaryLadderWidth() {
        return getCount() - 1;
    }

    public int getCount() {
        return participants.size();
    }

    public List<Participant> getValues() {
        return participants;
    }
}
