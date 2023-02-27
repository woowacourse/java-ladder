package laddergame.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "당첨", "5000"})
    @DisplayName("실행 결과가 빈 값이 아니고 공백을 포함하지 않는다면, 예외가 발생하지 않는다.")
    void does_not_throw_exception_if_result_is_not_empty_and_has_not_blank(String invalidResult) {
        assertDoesNotThrow(() -> new Result(invalidResult));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실행 결과가 null이나 빈 값이면, 예외가 발생한다.")
    void throws_exception_if_result_is_null_or_empty(String invalidResult) {
        assertThatThrownBy(() -> new Result(invalidResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 실행 결과는 null 이거나 빈 값일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" 꽝", "꽝 ", " 꽝 "})
    @DisplayName("실행 결과에 공백이 포함되면, 예외가 발생한다.")
    void throws_exception_if_result_has_blank(String invalidResult) {
        assertThatThrownBy(() -> new Result(invalidResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("[ERROR] 실행 결과에 공백이 포함될 수 없습니다. 입력된 값 : %s", invalidResult));
    }
}
