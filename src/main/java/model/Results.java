package model;

import dto.ParticipantName;
import dto.ResultsDto;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Results {
    private final Map<ParticipantName, Integer> results;

    public Results(Ladder ladder, Participants participants) {
        this.results = climbDown(ladder, participants);
    }

    private Map<ParticipantName, Integer> climbDown(Ladder ladder, Participants participants) {
        Map<ParticipantName, Integer> results = new HashMap<>();
        for (int i = 0; i < participants.getParticipantsSize(); i++) {
            results.put(participants.captureParticipantsName().get(i), ladder.climbDownEach(i));
        }
        return results;
    }

    public List<Integer> getResultIndexes() {
        return results.values().stream().toList();
    }

    public ResultsDto captureResult() {
        return new ResultsDto(this);
    }

    public Map<ParticipantName, Integer> getResults() {
        return results;
    }
}
