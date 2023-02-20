package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards, int playerCount) {
        validateRewardCount(rewards.size(), playerCount);
        this.rewards = rewards;
    }

    private void validateRewardCount(int rewardCount, int playerCount) {
        if (rewardCount != playerCount) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_REWARD_COUNT.getMessage());
        }
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

}
