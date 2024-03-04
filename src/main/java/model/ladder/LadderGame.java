package model.ladder;

import model.participant.Participant;
import model.participant.Participants;
import model.position.Position;
import model.result.ParticipantsResult;
import model.result.Result;
import model.result.Results;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final ParticipantsResult participantsResult;

    public LadderGame(Ladder ladder, Participants participants, Results results) {
        this.ladder = ladder;
        this.participantsResult = match(participants, results);
    }

    private ParticipantsResult match(Participants participants, Results results) {
        Map<Participant, Result> matched = new LinkedHashMap<>();
        for (Participant participant : participants.getParticipants()) {
            Position position = ladder.getFinishPositionBy(participants.getPosition(participant));
            matched.put(participant, results.getResult(position));
        }
        return new ParticipantsResult(matched);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public ParticipantsResult getParticipantsResult() {
        return participantsResult;
    }
}
