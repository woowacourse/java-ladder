package domain.result;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

    @DisplayName("결과는 1글자 이상, 5글자 이하여야 한다.")
    @ParameterizedTest(name = "결과 {0}가 정상적으로 생성된다.")
    @ValueSource(strings = {"1", "12345"})
    void constructSuccess(String resultName) {
        assertThatNoException()
                .isThrownBy(() -> new Prize(resultName));
    }

    @DisplayName("앞,뒤 공백이 존재한다면 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"  1234", "1234   ", "   1234   "})
    void constructSuccessAfterStripName(String resultName) {
        assertThat(resultName.strip().length())
                .isNotEqualTo(resultName.length());
        assertThatThrownBy(() -> new Prize(resultName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결과가 null일 경우 예외가 발생한다.")
    @Test
    void constructFailWithNull() {
        assertThatThrownBy(() -> new Prize(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결과가 빈 문자열로 이루어질 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void constructFailWithEmptyName(String resultName) {

        assertThatThrownBy(() -> new Prize(resultName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("결과는 6글자를 넘으면 예외가 발생한다.")
    @Test
    void constructFailWithTooLongName() {
        assertThatThrownBy(() -> new Prize("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
