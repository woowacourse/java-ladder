package laddergame.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    private static final String ERROR_MESSAGE_HEAD = "[ERROR]";

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실행 결과가 null이나 빈 값이면, 예외가 발생한다.")
    void throws_exception_if_result_is_null_or_empty(String invalidResult) {
        assertThatThrownBy(() -> new Result(invalidResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEAD);
    }

    @ParameterizedTest
    @ValueSource(strings = {" 꽝", "꽝 ", " 꽝 "})
    @DisplayName("실행 결과에 공백이 포함되면, 예외가 발생한다.")
    void throws_exception_if_result_has_blank(String invalidResult) {
        assertThatThrownBy(() -> new Result(invalidResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEAD);
    }
}
