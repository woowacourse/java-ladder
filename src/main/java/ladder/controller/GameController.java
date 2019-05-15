package ladder.controller;

import ladder.domain.Ladder;
import ladder.domain.Participant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class GameController {
    private static final int MIN_PARTICIPANTS_NUMBER = 2;
    private List<Participant> participants = new ArrayList<>();
    private Ladder ladder;

    public void registParticipant(List<String> participants){
        validateMinParticipants(participants);
        validateDuplicatedParticipants(participants);
        participants.stream().forEach(x -> this.participants.add(new Participant(x)));

    }

    private void validateMinParticipants(List<String> participants) {
        if(participants.size() < MIN_PARTICIPANTS_NUMBER) {
            throw new IllegalArgumentException("참가자는 2명 이상이어야 합니다.");
        }
    }

    private void validateDuplicatedParticipants (List<String> participants){
        if(participants.size()!= new HashSet<>(participants).size()){
            throw new IllegalArgumentException("참가자 명은 중복될 수 업습니다.");
        }
    }

    public void makeLadder(int height) {
        ladder = new Ladder(height, participants.size());
    }

    public Ladder getLadder(){
        return ladder;
    }

    public List<Participant> getParticipants() {
        return participants;
    }
}
