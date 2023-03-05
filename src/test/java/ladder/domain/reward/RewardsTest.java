package ladder.domain.reward;

import ladder.domain.laddergame.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class RewardsTest {

    private final int numberOfPlayers = 3;
    private List<String> rewardNames;

    @ParameterizedTest
    @CsvSource(value = {"0,꽝", "1,3000", "2,500"})
    @DisplayName("특정 위치값에 해당하는 보상을 반환한다")
    void findRewardByIndexTest(final int index, final String reward) {
        rewardNames = List.of("꽝", "3000", "500");
        final Rewards rewards = new Rewards(numberOfPlayers, rewardNames);

        assertThat(rewards.findRewardBy(new Position(index))
                .getName())
                .isEqualTo(reward);

    }

    @Nested
    @DisplayName("Rewards 객체를 생성할 때, ")
    class RewardInitiatorTest {
        @Test
        @DisplayName("보상의 수가 입력한 플레이어의 수와 일치하지 않으면 예외가 발생한다")
        void validateNumberOfRewardTest() {
            rewardNames = List.of("꽝");

            Assertions.assertThatThrownBy(() -> new Rewards(numberOfPlayers, rewardNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("보상의 개수는 플레이어 수와 일치해야 합니다.");
        }

        @Test
        @DisplayName("보상의 수가 플레이어 수와 일치하지만, 입력 받은 보상 중에 비어있는 경우 예외가 발생한다")
        void validateBlankRewardTest() {
            rewardNames = List.of("꽝", "", "5만원");

            Assertions.assertThatThrownBy(() -> new Rewards(numberOfPlayers, rewardNames))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("보상을 입력하지 않았습니다.");
        }

        @Test
        @DisplayName("모든 조건이 충족되면, 정상적으로 Rewards 객체가 생성된다")
        void validateCorrectRewardTest() {
            rewardNames = List.of("꽝", "3000", "500");

            assertDoesNotThrow(() -> new Rewards(numberOfPlayers, rewardNames));
        }
    }

}
