package ladder.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

class RewardTest {

    @ParameterizedTest
    @DisplayName("보상(실행 결과)이 1자 미만 5자 초과이면 예외처리 테스트")
    @ValueSource(strings = {"", "100000", "MacBook"})
    void invalidRewardLengthTest(String input) {
        Assertions.assertThatThrownBy(() -> new Reward(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("보상(실행 결과)이 1자 이상 5자 이하면 통과 테스트")
    @ValueSource(strings = {"꽝", "50000"})
    void validRewardLengthTest(String input) {
        assertThatCode(() -> new Reward(input))
                .doesNotThrowAnyException();
    }

}
