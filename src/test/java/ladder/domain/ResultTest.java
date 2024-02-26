package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    @DisplayName("결과가 1글자 미만이면 예외가 발생한다.")
    void createEmptyResult() {
        // given
        String value = "";

        // when & then
        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과가 5글자 초과이면 예외가 발생한다.")
    void createExtendedResult() {
        // given
        String value = "honux1";

        // when & then
        assertThatThrownBy(() -> new Result(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
