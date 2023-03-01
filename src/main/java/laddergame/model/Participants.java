package laddergame.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {
    private static final int MIN_PARTICIPANTS_LENGTH = 2;
    private static final String ERROR_PARTICIPANTS_LENGTH = "최소 참여자의 수는 " + MIN_PARTICIPANTS_LENGTH + "명 이상이어야 합니다.";
    private static final String ERROR_DUPLICATION = "참여자들 이름에 중복이 있어서는 안됩니다.";

    private final List<Participant> participants;

    public Participants(List<String> names) {
        validatePersonLength(names);
        validateDuplication(names);
        this.participants = convertToParticipants(names);
    }

    private void validatePersonLength(List<String> names) {
        if (names.size() < MIN_PARTICIPANTS_LENGTH) {
            throw new IllegalArgumentException(ERROR_PARTICIPANTS_LENGTH);
        }
    }

    private void validateDuplication(List<String> names) {
        Set<String> removeDuplicateNames = new HashSet<>(names);
        if (removeDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATION);
        }
    }

    private List<Participant> convertToParticipants(List<String> names) {
        return names.stream()
            .map(Participant::new)
            .collect(Collectors.toList());
    }

    public int getNumber() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public Participant gerParticipant(int i) {
        return participants.get(i);
    }
}
