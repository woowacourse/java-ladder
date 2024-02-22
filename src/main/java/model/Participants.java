package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Participants {
    private final List<Participant> participants;

    public Participants(List<String> participantsName) {
        validateNotDuplicateName(participantsName);
        validateParticipantSize(participantsName);
        this.participants = create(participantsName);
    }

    private void validateNotDuplicateName(List<String> participantsName){
        Set<String> distinctNames = new HashSet<>(participantsName);
        if(distinctNames.size() != participantsName.size()){
            throw new IllegalArgumentException("중복된 참가자들은 존재할 수 없습니다.");
        }
    }

    private void validateParticipantSize(List<String> participantsName) {
        if (participantsName.size() <= 1) {
            throw new IllegalArgumentException("참가자가 1명 이하인 경우는 존재할 수 없습니다.");
        }
    }

    private List<Participant> create(List<String> participantsName){
        return participantsName.stream().map(Participant::new).toList();
    }

    public int size() {
        return this.participants.size();
    }

    public List<Participant> getParticipants() {
        return List.copyOf(participants);
    }
}
