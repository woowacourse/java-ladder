package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RewardTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "1", "99999"})
    @DisplayName("Reward 생성 성공: \"꽝\", 경계값(1, 99999)")
    void reward_ok(String rawName) {
        Reward reward = Reward.from(rawName);
        assertThat(reward.getName()).isEqualTo(rawName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "100000"})
    @DisplayName("Reward 생성 실패: 경계값(0, 100000)")
    void reward_exception_outOfRange(String rawName) {
        assertThatThrownBy(() -> Reward.from(rawName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("1 이상 99999 이하의 숫자만 입력 가능합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"꾕", "!@#", "abc"})
    @DisplayName("Reward 생성 실패: 허용하지 않는 문자")
    void reward_exception_illegalInput(String rawName) {
        assertThatThrownBy(() -> Reward.from(rawName))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("숫자 혹은 '꽝'만 입력 가능합니다.");
    }

    @Test
    @DisplayName("Reward 생성 실패: null")
    void reward_exception_null() {
        assertThatThrownBy(() -> Reward.from(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("null을 입력할 수 없습니다.");
    }

    @Test
    @DisplayName("Reward 생성 실패: 빈 문자열")
    void reward_exception_blank() {
        assertThatThrownBy(() -> Reward.from("   "))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("빈 문자열을 입력할 수 없습니다.");
    }
}
