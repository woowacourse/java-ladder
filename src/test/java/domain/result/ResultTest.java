package domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static domain.result.Result.VALUE_LENGTH_RANGE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ResultTest {

    @DisplayName("값은 공백 제외 1~5자 사이여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    void checkValueLength(String value) {
        Result result = new Result(value);

        assertThat(result.getValue()).isEqualTo(value);
    }

    @DisplayName("값이 공백 제외 1~5자 사이가 아니면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void checkValueLengthWithException(String value) {
        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(VALUE_LENGTH_RANGE_MESSAGE);
    }
}
