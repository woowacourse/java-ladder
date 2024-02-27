package domain;

import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        this.rewards = rewards;
    }

    public String getRewardByIndex(int index) {
        return rewards.get(index).getReward();
    }
}
