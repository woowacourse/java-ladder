package model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        validateParticipantsSize(participants);
        validateParticipantsDuplication(participants);
        this.participants = participants;
    }

    private void validateParticipantsSize(List<Participant> participants) {
        if (participants == null || participants.size() < 2) {
            throw new IllegalArgumentException("[ERROR] 참여자는 2명 이상이어야 한다.");
        }
    }

    private void validateParticipantsDuplication(List<Participant> participants) {
        Set<String> set = participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toUnmodifiableSet());
        if (set.size() != participants.size()) {
            throw new IllegalArgumentException("[ERROR] 참여자 이름이 중복되었습니다.");
        }
    }

    public int getSize() {
        return participants.size();
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
