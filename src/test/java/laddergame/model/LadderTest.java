package laddergame.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 테스트")
    void Should_Success_When_MakeLadder() {
        int height = 4;
        assertDoesNotThrow(() -> new Ladder(new Height(height)));
    }
}
