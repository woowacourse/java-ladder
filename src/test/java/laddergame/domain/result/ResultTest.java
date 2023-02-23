package laddergame.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("실행 결과가 null이나 빈 값이면, 예외가 발생한다.")
    void throws_exception_if_result_is_null_or_empty(String invalidResult) {
        assertThatThrownBy(() -> new Result(invalidResult))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}
