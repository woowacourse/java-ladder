package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RewardTest {

    @DisplayName("보상 객체를 정상 생성합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"꽝", "당첨", "당첨당첨당"})
    void createReward(String validRewardName) {
        Assertions.assertThatCode(() -> new Reward(validRewardName))
                .doesNotThrowAnyException();
    }

    @DisplayName("보상이 5글자가 넘을 경우 예외처리")
    @Test
    void createRewardWithOverLength() {
        Assertions.assertThatThrownBy(() -> new Reward("당첨당첨당첨"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보상이 빈 문자열일 경우 예외처리")
    @Test
    void createRewardWithEmpty() {
        Assertions.assertThatThrownBy(() -> new Reward(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
