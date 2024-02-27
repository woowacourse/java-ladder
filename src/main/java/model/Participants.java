package model;

import java.util.*;

public class Participants {

    private static final String DUPLICATED_PARTICIPANT_NAME = "중복된 참가자들은 존재할 수 없습니다.";
    private static final String UNDER_PARTICIPANT_SIZE = "참가자가 1명 이하인 경우는 존재할 수 없습니다.";
    private static final int MINIMUM_PARTICIPANT_SIZE = 2;
    private final Map<Participant, Integer> participants;

    public Participants(List<String> participantsName) {
        validateNotDuplicateName(participantsName);
        validateParticipantSize(participantsName);
        this.participants = create(participantsName);
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

    private Map<Participant, Integer> create(List<String> participantsName) {
        Map<Participant, Integer> participants = new LinkedHashMap<>();
        for (int i = 0; i < participantsName.size(); i++) {
            participants.put(new Participant(participantsName.get(i)), i);
        }
        return participants;
    }

    public int size() {
        return this.participants.size();
    }

    public List<Participant> getParticipants() {
        return List.copyOf(participants.keySet());
    }

    public int getPosition(String name) {
        Participant participant = new Participant(name);
        if(participants.containsKey(participant)){
            return participants.get(participant);
        }
        throw new IllegalArgumentException("존재하지 않는 참가자의 이름입니다.");
    }
}
