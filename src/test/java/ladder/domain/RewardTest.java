package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RewardTest {

    @ParameterizedTest
    @ValueSource(strings = {"가", "#", "a", "a1", "1.1"})
    @DisplayName("\"꽝\" 이외의 실행 결과가 정수가 아니면 예외를 던진다.")
    void validateRewardNumericExceptNoLuckTest(String reward) {
        assertThatThrownBy(() -> new Reward(reward))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] \"꽝\" 이외의 실행 결과는 정수여야합니다.");
    }

    @Test
    @DisplayName("실행 결과가 \"꽝\"이면 정수가 아니어도 예외가 발생하지 않는다.")
    void validatePassWhenNoLuckTest() {
        String reward = "꽝";
        Assertions.assertDoesNotThrow(() -> new Reward(reward));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "10001", "10002"})
    @DisplayName("실행 결과가 정수일 때 1 이상 10000 이하가 아니면 예외를 던진다.")
    void validateRewardRangeTest(String reward) {
        assertThatThrownBy(() -> new Reward(reward))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] \"꽝\" 이외의 실행 결과는 1 이상 10000 이하의 정수여야합니다.");
    }
}
