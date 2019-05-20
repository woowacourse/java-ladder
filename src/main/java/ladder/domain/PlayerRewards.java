package ladder.domain;

import java.util.Map;
import java.util.Objects;

public final class PlayerRewards {
    private final Map<Integer, Reward> rewards;

    public PlayerRewards(final Map<Integer, Reward> rewards) {
        validateSize(rewards);
        this.rewards = rewards;
    }

    private void validateSize(Map<Integer, Reward> results) {
        if (results.isEmpty()) {
            throw new IllegalArgumentException("결과를 1개 이상 입력해 주세요");
        }
    }

    public int size() {
        return rewards.size();
    }

    public Reward getReward(int index) {
        return rewards.get(index);
    }

    public Map<Integer, Reward> getAllRewards() {
        return rewards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerRewards that = (PlayerRewards) o;
        return Objects.equals(rewards, that.rewards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rewards);
    }
}
