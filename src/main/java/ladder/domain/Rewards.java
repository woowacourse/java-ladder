package ladder.domain;

import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards(List<Reward> rewards) {
        validateNotNull(rewards);
        validateRewardsLength(rewards);
        this.rewards = rewards;
    }

    private void validateRewardsLength(List<Reward> rewards) {
        if (rewards.size() != Players.NUM_OF_PLAYERS) {
            throw new IllegalArgumentException("보상들의 수는 플레이어의 수와 일치해야합니다.");
        }
    }

    private void validateNotNull(List<Reward> rewards) {
        if (rewards == null) {
            throw new IllegalArgumentException("보상의 리스트는 null일 수 없습니다.");
        }
    }
}
