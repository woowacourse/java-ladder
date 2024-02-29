package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultItemTest {

    @DisplayName("결과 항목 값이 1글자 미만이면 예외가 발생한다.")
    @Test
    void validateNotEmpty() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ResultItem(""));
    }

    @Test
    @DisplayName("결과 항목 값이 5글자를 초과하면 예외가 발생한다.")
    void validateMaxLength() {
        // when & then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new ResultItem("honux1"));
    }

    @DisplayName("결과 항목을 생성한다.")
    @Test
    void createResultItem() {
        // when
        ResultItem resultItem = new ResultItem("꽝");

        // then
        assertThat(resultItem).extracting("value").isEqualTo("꽝");
    }
}
