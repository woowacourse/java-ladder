package domain;

import java.util.List;

import static utils.ErrorMessage.*;

public class Rewards {
    private static final int MAXIMUM_REWARD_LENGTH = 5;
    private static final int MINIMUM_REWARD_LENGTH = 1;
    public static final int FIRST_INDEX = 0;

    private final List<String> rewards;

    private Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<String> rewards, int userCount) {
        validateRewardsSize(rewards, userCount);
        validateRewardsLength(rewards);

        return new Rewards(rewards);
    }

    private static void validateRewardsLength(List<String> rewards) {
        for (String reward : rewards) {
            validateRewardLength(reward);
        }
    }

    private static void validateRewardLength(String reward) {
        if (reward.length() > MAXIMUM_REWARD_LENGTH || reward.length() < MINIMUM_REWARD_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(
                            INVALID_REWARD_LENGTH.getMessage(),
                            MINIMUM_REWARD_LENGTH, MAXIMUM_REWARD_LENGTH));
        }
    }

    private static void validateRewardsSize(List<String> rewards, int userCount) {
        if (rewards.size() != userCount) {
            throw new IllegalArgumentException(
                String.format(INVALID_REWARDS_SIZE.getMessage(),
                    userCount));
        }
    }

    private void validateIndex(int index) {
        if (index < FIRST_INDEX || index >= rewards.size()) {
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS.getMessage());
        }
    }

    public int size() {
        return rewards.size();
    }

    public String getReward(int index) {
        validateIndex(index);

        return rewards.get(index);
    }

}
