package domain;

import static utils.ErrorMessage.INDEX_OUT_OF_BOUNDS;
import static utils.ErrorMessage.INVALID_REWARDS_SIZE;

import java.util.List;

public class Rewards {

    public static final int FIRST_INDEX = 0;

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

    public int size() {
        return rewards.size();
    }

    public String getReward(int index) {
        if (index < FIRST_INDEX || index >= rewards.size()) {
            throw new IllegalArgumentException(INDEX_OUT_OF_BOUNDS.getMessage());
        }
        return rewards.get(index);
    }

}
