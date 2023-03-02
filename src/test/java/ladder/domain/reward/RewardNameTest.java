package ladder.domain.reward;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RewardNameTest {

    @ParameterizedTest(name = "reward: {0}")
    @ValueSource(strings = {"123456789", "123456"})
    @DisplayName("보상 길이가 5자를 초과하면 예외가 발생한다")
    void validateRewardIncorrectLengthTest(final String inputReward) {
        assertThatThrownBy(() -> new RewardName(inputReward))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보상은 5자 이하여야 합니다.");
    }

    @Test
    @DisplayName("보상 길이가 공백이면 예외가 발생한다")
    void validateRewardBlankTest() {
        final String inputReward = "";

        assertThatThrownBy(() -> new RewardName(inputReward))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보상을 입력하지 않았습니다.");
    }

    @ParameterizedTest(name = "reward: {0}")
    @ValueSource(strings = {"1", "12", "12345"})
    @DisplayName("보상 길이가 1자 이상 5자 이하면 정상적으로 생성된다")
    void validateRewardCorrectLengthTest(final String inputReward) {

        Assertions.assertDoesNotThrow(() -> new RewardName(inputReward));
    }

}
