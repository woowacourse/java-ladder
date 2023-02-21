package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("결과")
class ResultTest {
    @DisplayName("value가 비어있거나 null일 경우 예외가 발생한다.")
    @ParameterizedTest(name = "value = {0}")
    @NullAndEmptySource
    void throwExceptionWhenValueIsNullOrEmpty(final String value) {
        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("value가 공백일 경우 예외가 발생한다.")
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(strings = {"", " ", "  "})
    void throwExceptionWhenValueIsBlank(final String value) {
        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("값을 가져온다.")
    @ParameterizedTest(name = "value = {0}")
    @ValueSource(strings = {"hello", "helo"})
    void getValue(final String value) {
        final Result result = new Result(value);

        assertThat(result.getValue()).isEqualTo(value);
    }
}