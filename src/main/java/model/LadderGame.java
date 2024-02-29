package model;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final Map<Position, Result> resultByPosition;

    public LadderGame(Participants participants, Ladder ladder, Map<Position, Result> resultByPosition) {
        if (resultByPosition.size() != participants.size()) {
            throw new IllegalArgumentException("입력한 참가자와 결과의 개수가 동일하지 않습니다.");
        }
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
        Map<Name, Integer> allNameAndPosition = participants.mapAllNameAndPosition();
        for (Name name : allNameAndPosition.keySet()) {
            allParticipantResults.put(name, findParticipantResult(name));
        }
        return allParticipantResults;
    }
}
