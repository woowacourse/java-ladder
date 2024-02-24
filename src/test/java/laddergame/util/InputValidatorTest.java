package laddergame.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @DisplayName("빈문자열이나 공백을 입력하면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", "", "   "})
    @NullSource
    void testBlank(String value) {
        Assertions.assertThatThrownBy(() -> InputValidator.validateBlank(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값에 빈값을 입력할 수 없습니다.");
    }
}
