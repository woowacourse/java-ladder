package ladder.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import ladder.error.ErrorMessage;

class ResultTest {
    @ParameterizedTest(name = "실행결과를 검증한다.")
    @ValueSource(strings = {"당첨", "대   박", "", " 축당첨 ", "#$%@!"})
    void createResultSuccessTest(String result) {
        assertDoesNotThrow(() -> new Result(result));
    }

    @Test
    @DisplayName("각 실행결과는 5글자 이하여야 한다.")
    void createResultFailByLengthTest() {
        assertThatThrownBy(() -> new Result("ABCDEF")).
            isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_RESULT_LENGTH.getMessage());
    }

    @Test
    @DisplayName("각 실행 결과는 null일 수 없다.")
    void createResultFailByNullTest() {
        assertThatThrownBy(() -> new Result(null))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.RESULT_IS_NULL.getMessage());
    }

    @Test
    @DisplayName("각 실행 결과에 쉼표(,)가 포함될 수 없다.")
    void createResultFailByIncludingCommaTest() {
        assertThatThrownBy(() -> new Result("당,첨"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_RESULT_FORMAT.getMessage());
    }
}
