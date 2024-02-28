package model.result;

import model.participant.Participant;

import java.util.LinkedHashMap;
import java.util.Map;

public class Rewards {
    private final Map<Participant, Result> rewards;

    public Rewards(Map<Participant, Result> rewards) {
        this.rewards = new LinkedHashMap<>(rewards);
    }

    public Map<Participant, Result> getRewards() {
        return new LinkedHashMap<>(rewards);
    }
}
