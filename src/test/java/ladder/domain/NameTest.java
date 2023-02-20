package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.text.MessageFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"pobi", "CRONG", "EddY"})
    @DisplayName("이름은 영문자만 가능하다.")
    void personNameFormat(final String value) {
        assertThatNoException().isThrownBy(() -> new Name(value));
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"", "po bi", "세종대왕", "123", "!@#$%", " pobi", "pobi ", " hi "})
    @DisplayName("이름이 영문자가 아니라면 예외를 던진다.")
    void throwExceptionWhenNameNotEnglish(final String value) {
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(MessageFormat.format("사람 이름은 영문자만 가능합니다. 현재 입력은 {0} 입니다.", value));
    }

    @Test
    @DisplayName("이름에 NULL이 들어오면 예외를 던진다.")
    void throwExceptionWhenNameIsNull() {
        assertThatThrownBy(() -> new Name(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("5글자가 넘어가는 이름은 예외를 던진다.")
    void throwExceptionWhenNameLengthOverFive() {
        final String value = "abcdef";

        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
