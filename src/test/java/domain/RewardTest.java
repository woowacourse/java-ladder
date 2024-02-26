package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class RewardTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "1", "99999"})
    @DisplayName("실행결과 객체 생성 성공: 꽝, 경계값(1, 99999)")
    void reward_ok(String rawName) {
        Reward reward = Reward.from(0, rawName);
        assertThat(reward.getName()).isEqualTo(rawName);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "100000"})
    @DisplayName("실행결과 객체 생성 실패: 경계값(0, 100000)")
    void reward_exception_outOfRange(String rawName) {
        assertThatThrownBy(() -> Reward.from(0, rawName))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {"꾕", "!@#", "abc"})
    @DisplayName("실행결과 객체 생성 실패: null, empty, 허용하지 않는 문자")
    void reward_exception_illegalInput(String rawName) {
        assertThatThrownBy(() -> Reward.from(0, rawName))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
