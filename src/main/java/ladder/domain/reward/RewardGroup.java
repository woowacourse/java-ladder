package ladder.domain.reward;

import java.util.ArrayList;
import java.util.List;

public class RewardGroup {
    private final List<Reward> rewards = new ArrayList<>();

    public RewardGroup(final List<String> rewards, int size) {
        validateRewardsSize(rewards, size);
        rewards.forEach(x -> this.rewards.add(new Reward(x)));
    }

    private void validateRewardsSize(List<String> rewards, int size) {
        if (rewards.size() != size) {
            throw new IllegalArgumentException("게임 결과의 개수는 게임 참가자의 수와 일치해야 합니다.");
        }
    }

    public Reward getNthReward(int index) {
        return rewards.get(index);
    }

    public List<Reward> getRewardList() {
        return rewards;
    }

    public int getSize() {
        return rewards.size();
    }
}
