package laddergame.model.participants;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {
    private static final int MINIMUM_PARTICIPANTS_SIZE = 2;

    private final List<Participant> participants;

    public Participants(List<Participant> participants) {
        validateParticipantsSize(participants);
        validateParticipantsDuplication(participants);
        this.participants = participants;
    }

    private void validateParticipantsSize(List<Participant> participants) {
        if (participants == null || participants.size() < MINIMUM_PARTICIPANTS_SIZE) {
            String message = "[ERROR] 참여자는 " + MINIMUM_PARTICIPANTS_SIZE + "명 이상이어야 합니다.";
            throw new IllegalArgumentException(message);
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

    public boolean contains(Participant participant) {
        return participants.contains(participant);
    }

    public List<IndexInfo> getIndexInfos() {
        return participants.stream()
                .map(participant -> new IndexInfo(participant, indexOf(participant)))
                .toList();
    }

    public int indexOf(Participant participant) {
        return participants.indexOf(participant);
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
