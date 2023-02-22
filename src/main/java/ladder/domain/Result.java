package ladder.domain;

public class Result {

    private final Reward reward;

    public Result(final Reward reward) {
        this.reward = reward;
    }

    public boolean isSameReward(int rewardIndex) {
        return reward.isSameRewardIndex(rewardIndex);
    }
}
