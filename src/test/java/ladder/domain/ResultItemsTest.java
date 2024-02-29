package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultItemsTest {

    @DisplayName("결과 항목 수가 참여자 수와 같지 않으면 예외가 발생한다.")
    @Test
    void validateSize() {
        // when & then
        assertThatThrownBy(() -> new ResultItems(2, "꽝", "5000", "꽝", "3000"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
