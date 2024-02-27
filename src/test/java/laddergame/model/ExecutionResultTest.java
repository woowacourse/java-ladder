package laddergame.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class ExecutionResultTest {
    @DisplayName("실행 결과가 null 또는 공백일 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"  ", "    "})
    void validateName(String given) {
        assertThatThrownBy(() -> new ExecutionResult(given))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
