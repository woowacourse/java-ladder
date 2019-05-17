package ladder.domain;

import java.util.List;

public class Rewards {
    private final List<String> rewards;

    public Rewards(final List<String> rewards, int size) {
        validateRewardsSize(rewards, size);
        this.rewards = rewards;
    }

    private void validateRewardsSize(List<String> rewards, int size) {
        if (rewards.size() != size) {
            throw new IllegalArgumentException("게임 결과의 개수는 게임 참가자의 수와 일치해야 합니다.");
        }
    }

    public String getNthReward(int index) {
        return rewards.get(index);
    }

    public List<String> getRewardList() {
        return rewards;
    }
}
