package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rewards {
    private final List<Reward> rewards = new ArrayList<>();

    public Rewards(List<String> rewards) {
        rewards.forEach(reward -> this.rewards.add(new Reward(reward)));
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }
}
