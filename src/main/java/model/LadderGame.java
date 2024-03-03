package model;

import java.util.Map;
import java.util.stream.Collectors;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final Results results;

    public LadderGame(Participants participants, Ladder ladder, Results results) {
        if (results.size() != participants.size()) {
            throw new IllegalArgumentException("입력한 참가자와 결과의 개수가 동일하지 않습니다.");
        }
        this.participants = participants;
        this.ladder = ladder;
        this.results = results;
    }

    public Result findParticipantResult(Participant participant) {
        Position participantsPosition = participants.findPosition(participant);
        Position resultPosition = ladder.findLinkedPosition(participantsPosition);
        return results.findResult(resultPosition);
    }

    public Participant findParticipant(Name name) {
        return participants.findParticipantByName(name);
    }

    public Map<Participant, Result> findAllParticipantResults() {
        return participants.getParticipants()
                .stream()
                .collect(Collectors.toMap(
                        participant -> participant,
                        this::findParticipantResult
                ));
    }
}
