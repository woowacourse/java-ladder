package domain;

public class Reward {
    private static final int MAXIMUM_REWARD_LENGTH = 5;

    private final String reward;

    public Reward(String reward) {
        validateLength(reward);
        this.reward = reward;
    }

    private void validateLength(String reward) {
        if (reward.length() > MAXIMUM_REWARD_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    public String getReward() {
        return reward;
    }
}
