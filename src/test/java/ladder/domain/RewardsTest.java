package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

class RewardsTest {

    private final int numberOfPlayers = 3;
    private List<Reward> rewards;


    @Nested
    @DisplayName("Rewards 객체를 생성할 때, ")
    class RewardInitiatorTest {
        @Test
        @DisplayName("보상의 수가 입력한 플레이어의 수와 일치하지 않으면 예외가 발생한다")
        void validateNumberOfRewardTest() {
            rewards = List.of(new Reward("꽝"));

            Assertions.assertThatThrownBy(() -> new Rewards(numberOfPlayers, rewards))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("보상의 개수는 플레이어 수와 일치해야 합니다.");
        }

        @Test
        @DisplayName("보상의 수가 플레이어 수와 일치하지만, 입력 받은 보상 중에 비어있는 경우 예외가 발생한다")
        void validateBlankRewardTest() {
            rewards = List.of(new Reward("꽝"), new Reward(""), new Reward("5만원"));

            Assertions.assertThatThrownBy(() -> new Rewards(numberOfPlayers, rewards))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("보상을 입력하지 않았습니다.");
        }

        @Test
        @DisplayName("모든 조건이 충족되면, 정상적으로 Rewards 객체가 생성된다")
        void validateBlankRewardTest() {
            rewards = List.of(new Reward("꽝"), new Reward("3000"), new Reward("500"));

            Assertions.assertThatThrownBy(() -> new Rewards(numberOfPlayers, rewards))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("보상을 입력하지 않았습니다.");
        }
    }


}
