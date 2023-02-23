package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PrizeTest {

    @Test
    @DisplayName("사다리 상품이 정상적으로 생성된다.")
    void prizeCreateTest() {
        String prize = "prize";
        assertDoesNotThrow(() -> new Prize(prize));
    }
}
