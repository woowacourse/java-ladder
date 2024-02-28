package model.ladder;

import model.result.Result;
import model.result.Results;
import model.participant.Participant;
import model.participant.Participants;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {
    private final Ladder ladder;
    private final Participants participants;
    private final Results results;

    public LadderGame(Ladder ladder, Participants participants, Results results) {
        this.ladder = ladder;
        this.participants = participants;
        this.results = results;
    }

    public Result matchResult(Participant participant) {
        return results.getResult(ladder.getEndPositionBy(participants.getPosition(participant)));
    }

    public Map<Participant, Result> matchAllResults() {
        Map<Participant, Result> rewards = new LinkedHashMap<>();
        for (Participant participant : participants.getParticipants()) {
            rewards.put(participant, results.getResult(
                    ladder.getEndPositionBy(
                            participants.getPosition(participant)))
            );
        }
        return rewards;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Participants getParticipants() {
        return participants;
    }

    public Results getResults() {
        return results;
    }
}
