package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardsTest {

    @Test
    @DisplayName("Rewards 안에 있는 Reward 의 개수는 사람 수와 같아야 한다.")
    void should_rewardCountEqualToUserCount_when_rewards() {
        Reward reward1 = new Reward("결과1");
        Reward reward2 = new Reward("결과2");

        Rewards rewards = new Rewards(List.of(reward1, reward2), 2);

        Assertions.assertThat(rewards.getRewards()).containsExactly(reward1, reward2);
    }

    @Test
    @DisplayName("Rewards 안에 있는 Reward 의 개수가 사람 수와 같지 않다면 예외를 던진다.")
    void should_throwException_when_rewardCountNotEqualToUserCount() {
        Reward reward1 = new Reward("결과1");
        Reward reward2 = new Reward("결과2");

        Assertions.assertThatThrownBy(() -> new Rewards(List.of(reward1, reward2), 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
