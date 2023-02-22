package domain;

import static utils.ErrorMessage.INVALID_REWARDS_SIZE;

import java.util.List;
import java.util.stream.Collectors;

public class Rewards {

    private final int FIRST_INDEX = 0;
    private final List<String> rewards;

    private Rewards(List<String> rewards) {
        this.rewards = rewards.stream()
            .map(String::strip)
            .collect(Collectors.toList());
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

    public String getReward(int index) {
        if (index < FIRST_INDEX || index >= rewards.size()) {
            throw new IllegalArgumentException();
        }
        return rewards.get(index);
    }
}
