package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @Test
    @DisplayName("사다리 상품이 정상적으로 생성된다.")
    void prizeCreateTest() {
        String prize = "prize";
        assertDoesNotThrow(() -> new Prize(prize));
    }

    @Test
    @DisplayName("공백으로 사다리 상품을 생성할 경우 예외가 발생한다.")
    void prizeCreateExceptionTest() {
        String prize = "  ";
        assertThatThrownBy(() -> new Prize(prize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
