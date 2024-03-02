package model.ladder;

import model.participant.Participant;
import model.participant.Participants;
import model.result.Result;
import model.result.Results;
import model.result.ParticipantsResult;

import java.util.*;

public class LadderGame {
    private final Ladder ladder;
    private final ParticipantsResult participantsResult;

    public LadderGame(Ladder ladder, Participants participants, Results results) {
        this.ladder = ladder;
        this.participantsResult = match(participants, results);
    }

    private ParticipantsResult match(Participants participants, Results results) {
        Map<Participant, Result> rewards = new LinkedHashMap<>();
        for (Participant participant : participants.getParticipants()) {
            rewards.put(participant, results.getResult(
                    ladder.getEndPositionBy(participants.getPosition(participant)))
            );
        }
        return new ParticipantsResult(rewards);
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<Participant> getParticipants() {
        return new ArrayList<>(participantsResult.getParticipantsResult().keySet());
    }

    public List<Result> getResults() {
        return new ArrayList<>(participantsResult.getParticipantsResult().values());
    }

    public ParticipantsResult getParticipantsResult() {
        return participantsResult;
    }
}
