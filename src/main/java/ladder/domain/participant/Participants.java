package ladder.domain.participant;

import ladder.domain.participant.Participant;
import ladder.exception.DelimiterBoundaryException;
import ladder.exception.DuplicatedNamesException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Participants {
    private static final String DELIMITER = ",";

    private final List<Participant> participants;

    public Participants(String names) {
        validateDelimiterPosition(names);
        List<String> splitNames = splitNames(names);
        validateDuplicatedNames(splitNames);
        this.participants = splitNames.stream()
                .map(Participant::new)
                .toList();
    }

    private void validateDelimiterPosition(final String names) {
        if (names.startsWith(DELIMITER) || names.endsWith(DELIMITER)) {
            throw new DelimiterBoundaryException();
        }
    }

    private List<String> splitNames(final String names) {
        return Arrays.stream(names.split(DELIMITER)).toList();
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
