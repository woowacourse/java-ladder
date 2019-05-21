package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LadderTest {
    @Test
    void 입력값이_양수일_경우() {
        assertDoesNotThrow(() -> Ladder.checkHeightIsPositive(1));
    }

    @Test
    void 입력값이_양수가_아닐_경우_예외_반환() {
        assertThrows(NumberFormatException.class, () -> Ladder.checkHeightIsPositive(0));
    }
}
