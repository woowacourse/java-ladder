package ladder.model;

import ladder.exceptionMessage.ExceptionMessage;

public class Reward {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    private final String reward;

    public Reward(String reward) {
        validateRewardLength(reward);
        this.reward = reward;
    }

    private void validateRewardLength(String reward) {
        if (!isRewardLengthIncludedInRange(reward)) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_INVALID_REWARD_LENGTH.getMessage());
        }
    }

    private boolean isRewardLengthIncludedInRange(String reward) {
        return MIN_LENGTH <= reward.length() && reward.length() <= MAX_LENGTH;
    }

}
