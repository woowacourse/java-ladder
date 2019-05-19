package ladder.domain;

import java.util.Objects;

public class Reward {
    private static final int MAX_NAME_LENGTH = 5;

    private String reward;

    public Reward(String reward) {
        checkValidName(reward);
        this.reward = reward;
    }

    private void checkValidName(String reward) {
        checkBlankOrNull(reward);
        checkWrongLength(reward);
    }

    private void checkBlankOrNull(String reward) {
        if (reward == null || reward.trim().isEmpty()) {
            throw new IllegalArgumentException("상품은 1글자 이상이어야 합니다.");
        }
    }

    private void checkWrongLength(String reward) {
        if (reward.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("상품은 최대 5글자까지만 가능합니다.");
        }
    }

    public String getReward() {
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reward reward = (Reward) o;
        return Objects.equals(this.reward, reward.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }
}
