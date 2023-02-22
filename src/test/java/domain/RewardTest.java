package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("상품이")
public class RewardTest {

    @DisplayName("1 ~ 5 글자가 아니면 예외를 반환합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "pobibb"})
    void createRewardLengthFail(String input) {
        assertThatThrownBy(() -> new Reward(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("상품은 1 ~ 5 글자여야 합니다.");
    }

    @DisplayName("영어나 숫자가 아닌 경우 예외를 반환합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"$$$", "sdfk ", "sdf 1"})
    void createRewardValueFail(String input) {
        assertThatThrownBy(() -> new Reward(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 영어나 숫자로만 가능합니다.");
    }


    @DisplayName("정상적인 입력이 들어온 경우 생성됩니다.")
    @ParameterizedTest
    @ValueSource(strings = {"value", "hello", "pobi"})
    void createRewardSuccess(String input) {
        Reward reward = new Reward(input);

        assertThat(reward.getReward()).isEqualTo(input);
    }

}
