package domain.ladder;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LadderResultTest {

    @DisplayName("알맞은 값을 입력하면 정상적으로 생성된다.")
    @Test
    void create_success() {
        assertThatNoException().isThrownBy(() -> new LadderResult("value"));
    }

    @DisplayName("결과 명칭이 공백이면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    void create_fail_by_blank_value(String wrongName) {
        assertThatThrownBy(() -> new LadderResult(wrongName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과는 공백이거나 비어있을 수 없습니다.");
    }

    @DisplayName("결과 명칭의 길이가 5글자를 초과하면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123456", "1234567"})
    void create_fail_by_too_long_length(String wrongValue) {
        assertThatThrownBy(() -> new LadderResult(wrongValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("결과는 1글자 이상, 5글자 이하여야합니다.");
    }
}
