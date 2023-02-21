package domain;

import static utils.ErrorMessage.INVALID_REWARDS_SIZE;

import java.util.List;

public class Rewards {

    private final List<String> rewards;

    private Rewards(List<String> rewards) {
        this.rewards = rewards;
    }

    public static Rewards of(List<String> rewards, int userCount) {
        validateRewardsSize(rewards, userCount);
        return new Rewards(rewards);
    }

    private static void validateRewardsSize(List<String> rewards, int userCount) {
        if (rewards.size() != userCount) {
            throw new IllegalArgumentException(
                String.format(INVALID_REWARDS_SIZE.getMessage(),
                    userCount));
        }
    }
}
