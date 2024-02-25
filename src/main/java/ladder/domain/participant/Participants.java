package ladder.domain.participant;

import ladder.exception.participant.DuplicatedNamesException;
import ladder.exception.participant.InvalidParticipantsCountException;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Participants {
    private static final int MIN_PARTICIPANTS_COUNT = 2;

    private final List<Participant> participants;

    public Participants(final List<String> names) {
        validateParticipantsCount(names);
        validateDuplicatedNames(names);
        this.participants = createParticipants(names);
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

    private List<Participant> createParticipants(final List<String> names) {
        return IntStream.range(0, names.size())
                .mapToObj(position -> new Participant(names.get(position), position))
                .toList();
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
