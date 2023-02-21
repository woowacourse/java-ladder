package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ResultTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"", " ", "  ", "   ", "    "})
    @DisplayName("실행 결과가 공백이라면 예외를 던진다.")
    void throwExceptionWhenResultIsBlank(final String value) {
        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 공백일 수 없습니다. 현재 입력한 값은 " + value + " 입니다.");
    }

    @Test
    @DisplayName("실행 결과가 5글자 초과라면 예외를 던진다.")
    void throwExceptionWhenResultOverLength() {
        final String value = "abcedf";

        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 최대 5글자까지 가능합니다. 현재 입력한 값은 " + value + " 입니다.");
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @DisplayName("실행 결과가 5글자 이하라면 결과를 생성한다.")
    void successResult(final String value) {
        assertThatNoException().isThrownBy(() -> new Result(value));
    }
}
