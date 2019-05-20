package ladder.domain;

public class Reward {
    private static final int MAX_REWARD_LENGTH = Player.MAX_NAME_LENGTH;
    private static final int MIN_REWARD_LENGTH = Player.MIN_NAME_LENGTH;

    private final String reward;

    public Reward(final String reward) {
        validateRewardsLength(reward);
        this.reward = reward;
    }

    private static void validateRewardsLength(final String reward) {
        if (reward.length() > MAX_REWARD_LENGTH || reward.length() < MIN_REWARD_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return reward;
    }
}