package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Participants {

    private static final String DUPLICATED_PARTICIPANT_NAME = "중복된 참가자들은 존재할 수 없습니다.";
    private static final int MINIMUM_PARTICIPANT_SIZE = 2;
    private static final String UNDER_PARTICIPANT_SIZE
            = "참가자가 %d명 미만인 경우는 존재할 수 없습니다.".formatted(MINIMUM_PARTICIPANT_SIZE);

    private final List<Name> participantNames;

    public Participants(List<String> participantsName) {
        validateNotDuplicateName(participantsName);
        validateParticipantSize(participantsName);
        this.participantNames = createNames(participantsName);
    }

    private void validateNotDuplicateName(List<String> participantsName) {
        Set<String> distinctNames = new HashSet<>(participantsName);
        if (distinctNames.size() != participantsName.size()) {
            throw new IllegalArgumentException(DUPLICATED_PARTICIPANT_NAME);
        }
    }

    private void validateParticipantSize(List<String> participantsName) {
        if (participantsName.size() < MINIMUM_PARTICIPANT_SIZE) {
            throw new IllegalArgumentException(UNDER_PARTICIPANT_SIZE);
        }
    }

    private List<Name> createNames(List<String> participantsName) {
        return participantsName.stream()
                .map(Name::new)
                .toList();
    }

    public int getParticipantsSize() {
        return this.participantNames.size();
    }

    public List<Name> getParticipants() {
        return List.copyOf(participantNames);
    }
}
