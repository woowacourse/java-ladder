package ladder.domain.participant;

import ladder.exception.DuplicatedNamesException;

import java.util.List;
import java.util.Set;

public class Participants {

    private final List<Participant> participants;

    public Participants(List<String> names) {
        validateDuplicatedNames(names);
        this.participants = names.stream()
                .map(Participant::new)
                .toList();
    }

    private void validateDuplicatedNames(final List<String> names) {
        Set<String> uniqueNames = Set.copyOf(names);
        if (uniqueNames.size() < names.size()) {
            throw new DuplicatedNamesException();
        }
    }

    public int getCount() {
        return participants.size();
    }

    public List<Participant> getValues() {
        return participants;
    }
}
