package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsItemTest {

    @Test
    @DisplayName("결과 항목이 1글자 미만이면 예외가 발생한다.")
    void createEmptyResult() {
        // given
        String content = "";

        // when & then
        assertThatThrownBy(() -> new ResultItem(content))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("결과 항목이 5글자 초과면 예외가 발생한다.")
    void createExtendedResult() {
        // given
        String content = "honux1";

        // when & then
        assertThatThrownBy(() -> new ResultItem(content))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
