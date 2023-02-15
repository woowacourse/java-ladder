package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerTest {
    @ParameterizedTest
    @ValueSource(strings = {"\n", "\t", "  ", ""})
    @DisplayName("이름이 빈 문자열이면 예외가 발생해야 한다.")
    void name_throwExceptionIfEmptyString(String input) {
        // expected
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"aaaaaa", "akdfjqkf"})
    @DisplayName("이름은 6글자 이상이면 예외가 발생해야 한다.")
    void name_throwExceptionOver6(String input) {
        // expected
        assertThatThrownBy(() -> new Player(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"dochi", "vero", "a"})
    @DisplayName("이름은 최소 1글자, 최대 5글자이다.")
    void name_success(String input) {
        // expected
        assertThatCode(() -> new Player(input))
                .doesNotThrowAnyException();
    }
}
