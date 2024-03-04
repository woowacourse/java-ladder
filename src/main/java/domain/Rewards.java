package domain;

import java.util.List;
import message.ErrorMessage;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards, int playerCount) {
        validEqualPlayerCount(rewards.size(), playerCount);
        this.rewards = rewards;
    }

    private void validEqualPlayerCount(int size, int playerCount) {
        if (size != playerCount) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EQUAL_REWARD_PLAYER_COUNT_EXCEPTION.getMessage());
        }
    }

    public String getRewardByIndex(int index) {
        return rewards.get(index).getReward();
    }

    public List<Reward> getRewards() {
        return rewards;
    }
}
