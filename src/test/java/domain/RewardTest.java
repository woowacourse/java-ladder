package domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RewardTest {
    @DisplayName("보상의 글자수는 1글자 이상 5글자 이하이다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12", "1234", "12345"})
    void validRewardTest(String reward) {
        Assertions.assertDoesNotThrow(() -> new Reward(reward));
    }

    @DisplayName("보상의 글자수가 5글자 초과일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567"})
    void invalidLengthRewardTest(String reward) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Reward(reward))
                .withMessageContainingAll("[ERROR]", "글자 이하의 보상만 입력해주세요.");
    }

    @DisplayName("보상은 빈 문자열(공백)이거나 1글자 미만인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   "})
    void invalidBlankRewardTest(String reward) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Reward(reward))
                .withMessageContainingAll("[ERROR]", "빈 문자열(공백)은 보상이 될 수 없습니다.");
    }
}
