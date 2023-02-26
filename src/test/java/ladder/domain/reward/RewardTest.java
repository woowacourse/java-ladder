package ladder.domain.reward;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class RewardTest {

    @ParameterizedTest(name = "inputReward = {0}")
    @DisplayName("reward 생성 테스트")
    @ValueSource(strings = {"꽝", "5000", "당첨"})
    void createRewardTest(String inputReward) {
        assertDoesNotThrow(() -> new Reward(inputReward));
    }

    @ParameterizedTest(name = "inputReward = {0}")
    @DisplayName("reward 공백 예외 테스트")
    @ValueSource(strings = {"", "   "})
    void createRewardBlankExceptionTest(String inputReward) {
        assertThatThrownBy(() -> new Reward(inputReward)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "inputReward = {0}")
    @DisplayName("reward 최대 길이 예외 테스트")
    @ValueSource(strings = {"500000", "가나다", "aaaaaa"})
    void createRewardLengthExceptionTest(String inputReward) {
        assertThatThrownBy(() -> new Reward(inputReward)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "inputReward = {0}")
    @DisplayName("reward 생성 테스트")
    @ValueSource(strings = {"꽝", "5000", "당첨"})
    void getRewardTest(String inputReward) {
        Reward reward = new Reward(inputReward);
        assertThat(reward.getReward()).isEqualTo(inputReward);
    }

}
