package ladder.controller;

import ladder.domain.Ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderController {
    private static final int MIN_PARTICIPANTS_NUMBER = 2;
    private List<String> participants = new ArrayList<>();
    private Ladder ladder;

    public void registParticipant(List<String> participants){
        validateMinParticipants(participants);
        this.participants = participants;

    }

    private void validateMinParticipants(List<String> participants) {
        if(participants.size() < MIN_PARTICIPANTS_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public void makeLadder(int height) {
        ladder = new Ladder(height, participants.size());
    }

}
