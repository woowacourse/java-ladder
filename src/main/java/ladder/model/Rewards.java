package ladder.model;

import java.util.Collections;
import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

}
