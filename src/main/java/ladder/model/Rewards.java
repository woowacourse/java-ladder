package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Rewards {
    private final List<String> rewards;

    public Rewards(List<String> rewards, int playerCount) {
        validateRewardCount(rewards.size(), playerCount);
        this.rewards = rewards.stream()
                .map(this::removeWhiteSpace)
                .collect(Collectors.toList());
    }

    private void validateRewardCount(int rewardCount, int playerCount) {
        if (rewardCount != playerCount) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_REWARD_COUNT.getMessage());
        }
    }

    private String removeWhiteSpace(String reward) {
        return reward.replaceAll(" ", "");
    }

    public List<String> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

}
