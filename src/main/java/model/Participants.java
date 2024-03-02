package model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Participants {

    private static final String DUPLICATED_PARTICIPANT_NAME = "중복된 참가자들은 존재할 수 없습니다.";
    private static final String NOT_EXIST_PARTICIPANT = "존재하지 않는 참가자 입니다.";
    private static final String NOT_EXIST_PARTICIPANT_NAME = "존재하지 않는 참가자 이름입니다.";
    private static final int MINIMUM_PARTICIPANT_SIZE = 2;
    private static final String UNDER_PARTICIPANT_SIZE
            = "참가자가 %d명 미만인 경우는 존재할 수 없습니다.".formatted(MINIMUM_PARTICIPANT_SIZE);

    private List<Participant> participants;

    public Participants(List<Participant> participants) {
        validateNotDuplicateName(participants);
        validateParticipantSize(participants);
        this.participants = participants;
    }

    private void validateNotDuplicateName(List<Participant> participants) {
        Set<Name> distinctNames = participants.stream()
                .map(Participant::getName)
                .collect(Collectors.toSet());
        if (distinctNames.size() != participants.size()) {
            throw new IllegalArgumentException(DUPLICATED_PARTICIPANT_NAME);
        }
    }

    private void validateParticipantSize(List<Participant> participants) {
        if (participants.size() < MINIMUM_PARTICIPANT_SIZE) {
            throw new IllegalArgumentException(UNDER_PARTICIPANT_SIZE);
        }
    }

    public Position findPosition(Participant participant) {
        Participant foundParticipant = participants.stream()
                .filter(p -> p.equals(participant))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_PARTICIPANT));
        return foundParticipant.getPosition();
    }

    public Participant findParticipantByName(Name name) {
        return participants.stream()
                .filter(participant -> participant.isSameName(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXIST_PARTICIPANT_NAME));
    }

    public int size() {
        return this.participants.size();
    }

    public List<Participant> getParticipants() {
        return List.copyOf(participants);
    }
}
