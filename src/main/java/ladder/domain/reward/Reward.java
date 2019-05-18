package ladder.domain.reward;

public class Reward {
    private static final int MAX_REWARD_LENGTH = 5;

    private final String reward;

    public Reward(final String reward) {
        validateRewardLength(reward);
        this.reward = reward;
    }

    private void validateRewardLength(String reward) {
        if (reward.length() > MAX_REWARD_LENGTH) {
            throw new IllegalArgumentException("결과가 " + MAX_REWARD_LENGTH + "글자가 넘어갑니다.");
        }
    }

    @Override
    public String toString() {
        return reward;
    }
}