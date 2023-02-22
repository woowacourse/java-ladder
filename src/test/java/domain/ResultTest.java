package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {

    @DisplayName("결과에 1자 미만 5자 초과일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    void result_test(String value) {
        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("결과는 1자 이상 5자 이하여야 합니다.");
    }
}
