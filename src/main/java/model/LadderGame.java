package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final Map<Position, Result> resultByPosition;

    public LadderGame(Participants participants, Ladder ladder, Map<Position, Result> resultByPosition) {
        this.participants = participants;
        this.ladder = ladder;
        this.resultByPosition = resultByPosition;
    }

    public Result findParticipantResult(Name name) {
        Position participantPosition = participants.getPositionByName(name);
        Position resultPosition = ladder.moveAll(participantPosition);
        return resultByPosition.get(resultPosition);
    }

    public Map<Name, Result> findAllParticipantResults() {
        Map<Name, Result> allParticipantResults = new LinkedHashMap<>();
        Map<Name, Integer> allNameAndPosition = participants.getAllNameAndPosition();
        for (Name name : allNameAndPosition.keySet()) {
            allParticipantResults.put(name, findParticipantResult(name));
        }
        return allParticipantResults;
    }
}
