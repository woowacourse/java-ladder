package model;

import java.util.List;

public class Participants {
    private static final int MIN_PARTICIPANT_NAME = 2;
    private final List<Participant> participants;

    public Participants(List<String> names) {
        validatorNameSize(names);
        List<Participant> participants = names.stream()
                .map(Participant::new)
                .toList();
        this.participants = participants;
    }

    private void validatorNameSize(List<String> names) {
        if (names.size() < MIN_PARTICIPANT_NAME) {
            throw new IllegalArgumentException("참여할 사람은 두명 이상이어야한다.");
        }
    }
}
