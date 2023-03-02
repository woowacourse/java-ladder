package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"pobi", "CRONG", "EddY"})
    @DisplayName("이름은 영문자만 가능하다.")
    void should_valid_name(final String value) {
        assertThatNoException().isThrownBy(() -> new Player(value));
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"", "po bi", "세종대왕", "123", "!@#$%", " pobi", "pobi ", " hi "})
    @DisplayName("이름이 영문자가 아니라면 예외를 던진다.")
    void throw_exception_invalid_name(final String value) {
        assertThatThrownBy(() -> new Player(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 이름은 영문자만 가능합니다. 현재 입력은 " + value + "입니다.");
    }

    @Test
    @DisplayName("이름이 5글자 초과라면 예외를 던진다.")
    void throw_exception_name_length_over_5() {
        final String value = "abcdef";

        assertThatThrownBy(() -> new Player(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 이름은 5글자까지 가능합니다. 현재 입력은 " + value + "입니다.");
    }
}
