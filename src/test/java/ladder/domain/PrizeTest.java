package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrizeTest {

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"", " ", "  ", "   ", "    "})
    @DisplayName("당첨 항목이 공백이라면 예외를 던진다.")
    void throw_exception_blank_prize(final String value) {
        assertThatThrownBy(() -> new Prize(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 항목은 공백일 수 없습니다. 현재 입력한 값은 " + value + " 입니다.");
    }

    @Test
    @DisplayName("당첨 항목이 5글자 초과라면 예외를 던진다.")
    void throw_exception_invalid_prize_length() {
        final String value = "abcedf";

        assertThatThrownBy(() -> new Prize(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 항목은 최대 5글자까지 가능합니다. 현재 입력한 값은 " + value + " 입니다.");
    }

    @ParameterizedTest(name = "입력: {0}")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @DisplayName("당첨 항목이 5글자 이하라면 당첨 항목을 생성한다.")
    void should_generate_prize_when_valid_value(final String value) {
        assertThatNoException().isThrownBy(() -> new Prize(value));
    }
}
