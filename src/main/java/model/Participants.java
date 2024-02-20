package model;

import java.util.List;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<String> names) {
        validatorNameSize(names);
        List<Participant> participants = names.stream().map(Participant::new).toList();
        this.participants = participants;
    }

    private void validatorNameSize(List<String> names) {
        if (names.size() < 2) {
            throw new IllegalArgumentException("참여할 사람은 두명 이상이어야한다.");
        }
    }
}
