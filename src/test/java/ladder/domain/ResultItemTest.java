package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultItemTest {

    @Test
    @DisplayName("결과 항목의 앞뒤 공백은 제거한다.")
    void trimSpaces() {
        // when
        ResultItem resultItem = new ResultItem("    꽝    ");

        // then
        assertThat(resultItem)
                .extracting("content")
                .asString()
                .isEqualTo("꽝");
    }

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
