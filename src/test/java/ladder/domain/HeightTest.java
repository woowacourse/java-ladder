package ladder.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class HeightTest {

    @Test
    public void 높이_양수_아닐때_에러() {
        assertThrows(IllegalArgumentException.class, () -> new Height(0));
    }

    @Test
    public void 높이_양수_통과() {
        assertDoesNotThrow(() -> new Height(1));
    }

}