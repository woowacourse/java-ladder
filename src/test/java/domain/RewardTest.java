package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RewardTest {
    @DisplayName("결과명으로 Reward 객체 생성 테스트")
    @Test
    void 결과입력으로_Reward_객체_생성_테스트() {
        Assertions.assertDoesNotThrow(() -> {
            new Reward("꽝");
        });
    }

    @DisplayName("결과명으로 Reward 객체 생성 실패 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "       "})
    void 결과입력으로_Reward_객체_생성_실패_테스트(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Reward(name);
        });
    }
}
