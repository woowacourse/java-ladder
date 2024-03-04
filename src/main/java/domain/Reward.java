package domain;

import static message.ErrorMessage.NO_REWARD_NAME_EXCEPTION;

public class Reward {
    private static final int MAXIMUM_REWARD_LENGTH = 5;

    private final String reward;

    public Reward(String reward) {
        validate(reward);
        this.reward = reward;
    }

    private void validate(String reward) {
        validateLength(reward);
        validateRewardBlank(reward);
    }

    private void validateLength(String reward) {
        if (reward.length() > MAXIMUM_REWARD_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRewardBlank(String reward) {
        if (reward.isBlank()) {
            throw new IllegalArgumentException(NO_REWARD_NAME_EXCEPTION.getMessage());
        }
    }

    public String getReward() {
        return reward;
    }
}
