package laddergame.domain.reward;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Reward {
    public static final int BOUND_OF_NAME_LENGTH = 5;

    private final String reward;

    public Reward(String reward) throws IllegalArgumentException {
        if (StringUtils.isBlank(reward)) {
            throw new IllegalArgumentException("공백을 입력하였습니다");
        }
        if (reward.length() > this.BOUND_OF_NAME_LENGTH) {
            throw new IllegalArgumentException("5자리 이하 결과만 입력 가능합니다.");
        }
        this.reward = reward;
    }

    public String getName() {
        return this.reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reward)) return false;
        Reward reward1 = (Reward) o;
        return Objects.equals(reward, reward1.reward);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reward);
    }

    @Override
    public String toString() {
        return this.reward;
    }
}
