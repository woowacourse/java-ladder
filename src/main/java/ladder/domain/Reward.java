package ladder.domain;

public class Reward {
    private static final int MAX_REWARD_LENGTH = Player.MAX_NAME_LENGTH;
    private static final int MIN_REWARD_LENGTH = Player.MIN_NAME_LENGTH;

    private final String reward;

    Reward(final String reward) {
        validateRewardsLength(reward);
        this.reward = reward;
    }

    private static void validateRewardsLength(final String reward) {
        if (reward.length() > MAX_REWARD_LENGTH || reward.length() < MIN_REWARD_LENGTH) {
            throw new IllegalArgumentException("보상은 "+MIN_REWARD_LENGTH+"자 이상 "+MAX_REWARD_LENGTH+"자 이내여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return reward;
    }
}