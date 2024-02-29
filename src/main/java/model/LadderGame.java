package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final Map<Position, String> resultByPosition;

    public LadderGame(Participants participants, Ladder ladder, Map<Position, String> resultByPosition) {
        this.participants = participants;
        this.ladder = ladder;
        this.resultByPosition = resultByPosition;
    }

    public String findParticipantResult(Name name) {
        Position participantPosition = participants.getPositionByName(name);
        Position resultPosition = ladder.moveAll(participantPosition);
        return resultByPosition.get(resultPosition);
    }

    public Map<Name, String> findAllParticipantResults() {
        Map<Name, String> allParticipantResults = new LinkedHashMap<>();
        Map<Name, Integer> allNameAndPosition = participants.getAllNameAndPosition();
        for (Name name : allNameAndPosition.keySet()) {
            allParticipantResults.put(name, findParticipantResult(name));
        }
        return allParticipantResults;
    }
}
