package model.result;

import model.participant.Participant;

import java.util.LinkedHashMap;
import java.util.Map;

public class ParticipantsResult {
    private final Map<Participant, Result> rewards;

    public ParticipantsResult(Map<Participant, Result> rewards) {
        this.rewards = new LinkedHashMap<>(rewards);
    }

    public Map<Participant, Result> getRewards() {
        return new LinkedHashMap<>(rewards);
    }
}
