package domain;

import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards, int peopleNum) {
        validateRewards(rewards.size(), peopleNum);
        this.rewards = rewards;
    }

    private void validateRewards(int rewardNum, int peopleNum) {
        if (rewardNum != peopleNum) {
            throw new IllegalArgumentException("결과의 수는 참가자의 수와 동일해야 합니다.");
        }
    }

    public List<Reward> getRewards() {
        return rewards;
    }

    public int calculateMaxNameLength() {
        return rewards.stream().mapToInt(p -> p.getName().getRewardName().length()).max().orElseThrow();
    }
}
