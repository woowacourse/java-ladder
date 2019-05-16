package ladder.domain;

import java.util.Map;
import java.util.Objects;

public final class PlayerRewards {
    private final Map<Integer, String> rewards;

    public PlayerRewards(final Map<Integer, String> rewards) {
        validateSize(rewards);
        this.rewards = rewards;
    }

    private void validateSize(Map<Integer, String> results) {
        if (results.isEmpty()) {
            throw new IllegalArgumentException("결과를 1개 이상 입력해 주세요");
        }
    }

    public int size() {
        return rewards.size();
    }

    public String getReward(int num) {
        return rewards.get(num);
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
