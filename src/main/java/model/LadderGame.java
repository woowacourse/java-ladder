package model;

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

    public String matchResult(Participant participant){
        return results.getResult(ladder.resultPosition(participants.getPosition(participant)));
    }

    public Map<Participant, String> matchAllResult(){
        Map<Participant, String> rewards = new LinkedHashMap<>();
        for (Participant participant : participants.getParticipants()){
            rewards.put(participant, results.getResult(
                    ladder.resultPosition(participants.getPosition(participant)))
            );
        }
        return rewards;
    }
}
