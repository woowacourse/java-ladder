package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("상품은")
public class RewardTest {

    @DisplayName("1 ~ 5 글자가 아니면 예외를 반환합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "pobibb"})
    void createRewardFail(String input) {
        assertThatThrownBy(() -> new Reward(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("상품은 1 ~ 5 글자여야 합니다.");
    }

}
