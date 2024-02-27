package model;

import dto.ParticipantName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    Map<ParticipantName, Integer> resultIndexes;

    public Results(Ladder ladder, Participants participants) {
        this.resultIndexes = climbDown(ladder, participants);
    }

    private Map<ParticipantName, Integer> climbDown(Ladder ladder, Participants participants) {
        Map<ParticipantName, Integer> results = new HashMap<>();
        for (int i = 0; i < participants.getParticipantsSize(); i++) {
            results.put(participants.captureParticipantsName().get(i), ladder.climbDownEach(i));
        }
        return results;
    }

    public List<Integer> getResultIndexes() {
        return resultIndexes.values().stream().toList();
    }
}
