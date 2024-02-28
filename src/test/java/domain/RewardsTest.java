package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RewardsTest {

    @DisplayName("보상들 객체를 정상적으로 생성합니다.")
    @Test
    void createRewards() {
        assertThatCode(() -> new Rewards(List.of(new Reward("0")), 1))
                .doesNotThrowAnyException();
    }

    @DisplayName("플레이어수와 보상의 수가 일치하지 않으면 예외.")
    @Test
    void findRewardWithNotEqualSize() {
        assertThatThrownBy(() -> new Rewards(List.of(new Reward("0"), new Reward("1000")), 3))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("인덱스로 리워드를 찾습니다.")
    @Test
    void findRewardByIndex() {
        Rewards rewards = new Rewards(List.of(new Reward("0"), new Reward("1000")), 2);
        assertThat(rewards.getRewardByIndex(1)).isEqualTo("1000");
    }
}
