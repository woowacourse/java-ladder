package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.domain.ladder.reward.Reward;

class RewardTest {

    @DisplayName("입력한 결과가 1-5자 범위를 벗어날 경우 예외를 발생한다.")
    @ValueSource(strings = {"", "우아한테크코스"})
    @ParameterizedTest
    void constructException(String name) {
        assertThatThrownBy(() -> new Reward(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과는 1~5글자로 입력해주세요");
    }
}
