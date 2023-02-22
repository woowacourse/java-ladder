package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultTest {

    @Test
    @DisplayName("결과가 String으로 주어지면 Result객체가 반환돤다.")
    void givenResultStringName_thenReturnResult() {
        // given
        final String resultName = "꽝";

        // when
        final Result result = new Result(resultName);

        // then
        assertThat(result)
                .extracting("result")
                .isEqualTo(resultName);
    }
}
