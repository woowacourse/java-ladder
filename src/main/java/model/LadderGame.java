package model;

import java.util.Map;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final Map<Integer, String> resultByPosition;

    public LadderGame(Participants participants, Ladder ladder, Map<Integer, String> resultByPosition) {
        this.participants = participants;
        this.ladder = ladder;
        this.resultByPosition = resultByPosition;
    }


    public String findParticipantResult(Name name) {
        int participantPosition = participants.getPositionByName(name);
        int resultPosition = ladder.moveAll(participantPosition);
        return resultByPosition.get(resultPosition);
    }

    public Map<Name, String> findAllParticipantsResult() {
        return null;
    }
}
