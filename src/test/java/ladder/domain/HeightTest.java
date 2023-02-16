package ladder.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    void 높이_양수_아닐때_에러() {
        assertThrows(IllegalArgumentException.class, () -> Height.validateHeight(0));
    }

    @Test
    void 높이_양수_통과() {
        assertDoesNotThrow(() -> Height.validateHeight(1));
    }

}