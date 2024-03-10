package model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {
    private static final int MIN_LIMIT = 2;

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        validateParticipantsSize(participants);
        validateParticipantsDuplication(participants);
        this.participants = participants;
    }

    public Participant findTargetParticipant(String target) {
        Participant targetParticipant = new Participant(target);
        if (participants.contains(targetParticipant)) {
            return targetParticipant;
        }
        throw new IllegalArgumentException("[ERROR] 목록에 없는 참여자입니다.");
    }

    private void validateParticipantsSize(List<Participant> participants) {
        if (participants == null || participants.size() < MIN_LIMIT) {
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
