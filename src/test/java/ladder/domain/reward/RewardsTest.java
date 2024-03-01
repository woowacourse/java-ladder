package ladder.domain.reward;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ladder.domain.attribute.Width;

class RewardsTest {

    static List<Reward> rewards() {
        return List.of(
                new Reward("맥북에어"),
                new Reward("맥북프로"),
                new Reward("에어팟맥스")
        );
    }

    @DisplayName("사다리 결과의 개수가 인원수와 다르면 예외를 발생한다.")
    @Test
    void rewardsException() {
        List<Reward> rewards = List.of(
                new Reward("맥북에어"),
                new Reward("맥북프로")
        );

        assertThatThrownBy(() -> new Rewards(rewards, new Width<>(3)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("인원수와 결과의 개수가 일치하지 않습니다");
    }

    @DisplayName("인덱스를 입력하면 결과를 반환한다.")
    @Test
    void climbFrom() {
        Rewards rewards = new Rewards(rewards(), new Width<>(3));
        assertThat(rewards.get(0))
                .isEqualTo(new Reward("맥북에어"));
    }

    @DisplayName("잘못된 인덱스를 입력하면 예외를 발생한다.")
    @Test
    void climbFromException() {
        Rewards rewards = new Rewards(rewards(), new Width<>(3));
        assertThatThrownBy(() -> rewards.get(-1))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("잘못된 위치입니다");
    }
}
