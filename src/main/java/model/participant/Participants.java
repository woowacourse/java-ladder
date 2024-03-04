package model.participant;

import model.position.Position;

import java.util.*;

public class Participants {

    protected static final String NOT_ALLOWED_DUPLICATED_PARTICIPANT_NAME = "중복된 참가자들은 존재할 수 없습니다.";
    protected static final String NOT_ALLOWED_PARTICIPANT_SIZE_UNDER_THAN_TWO = "참가자가 1명 이하인 경우는 사다리 게임을 진행할 수 없습니다.";
    private static final int MINIMUM_PARTICIPANT_SIZE = 2;
    private final Map<Participant, Position> participants;

    public Participants(List<String> participantsName) {
        validateNotDuplicateName(participantsName);
        validateParticipantSize(participantsName);
        this.participants = create(participantsName);
    }

    private void validateNotDuplicateName(List<String> participantsName) {
        Set<String> distinctNames = new HashSet<>(participantsName);
        if (distinctNames.size() != participantsName.size()) {
            throw new IllegalArgumentException(NOT_ALLOWED_DUPLICATED_PARTICIPANT_NAME);
        }
    }

    private void validateParticipantSize(List<String> participantsName) {
        if (participantsName.size() < MINIMUM_PARTICIPANT_SIZE) {
            throw new IllegalArgumentException(NOT_ALLOWED_PARTICIPANT_SIZE_UNDER_THAN_TWO);
        }
    }

    private Map<Participant, Position> create(List<String> participantsName) {
        Map<Participant, Position> participants = new LinkedHashMap<>();
        for (int i = 0; i < participantsName.size(); i++) {
            participants.put(new Participant(participantsName.get(i)), Position.valueOf(i));
        }
        return participants;
    }

    public int size() {
        return this.participants.size();
    }

    public List<Participant> getParticipants() {
        return new ArrayList<>(participants.keySet());
    }

    public Position getPosition(Participant participant) {
        return participants.get(participant);
    }
}
