package ladder.model;

import static ladder.model.ErrorMessage.EXCEPTION_REWARD_LENGTH;

public class Reward {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String reward;

    public Reward(String reward) {
        validateReward(reward);
        this.reward = reward;
    }

    private void validateReward(String reward) {
        if (reward.length() < MIN_LENGTH || reward.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_REWARD_LENGTH.getMessage());
        }
    }

    public String getReward() {
        return reward;
    }

}
