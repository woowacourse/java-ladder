package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Participants {
    private static final int MIN_PARTICIPANT_NAME = 2;
    private final List<Participant> participants;

    public Participants(List<String> names) {
        validateNameSize(names);
        validateDuplicateName(names);
        List<Participant> participants = names.stream()
                .map(Participant::new)
                .toList();
        this.participants = participants;
    }

    private void validateNameSize(List<String> names) {
        if (names.size() < MIN_PARTICIPANT_NAME) {
            throw new IllegalArgumentException("참여할 사람은 두명 이상이어야한다.");
        }
    }

    private void validateDuplicateName(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (nonDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException("이름은 중복될 수 없다");
        }
    }

    public int getParticipantsSize() {
        return participants.size();
    }
}
