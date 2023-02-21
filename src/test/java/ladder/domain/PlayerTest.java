package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class PlayerTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"pobi", "CRONG", "EddY"})
    @DisplayName("이름은 영문자만 가능하다.")
    void playerNameFormat(final String value) {
        assertThatNoException().isThrownBy(() -> new Player(value));
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"", "po bi", "세종대왕", "123", "!@#$%", " pobi", "pobi ", " hi "})
    @DisplayName("이름이 영문자가 아니라면 예외를 던진다.")
    void throwExceptionWhenNameNotEnglish(final String value) {
        assertThatThrownBy(() -> new Player(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어 이름은 영문자만 가능합니다. 현재 입력은 " + value + "입니다.");
    }

    @ParameterizedTest(name = "입력: {0}")
    @NullSource
    @DisplayName("이름에 NULL이 들어오면 예외를 던진다.")
    void throwExceptionWhenNameIsNull(final String value) {
        assertThatThrownBy(() -> new Player(value))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("5글자가 넘어가는 이름은 예외를 던진다.")
    void throwExceptionWhenNameOverLength() {
        final String value = "abcdef";

        assertThatThrownBy(() -> new Player(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
