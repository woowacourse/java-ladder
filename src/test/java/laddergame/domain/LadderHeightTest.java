package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LadderHeightTest {

    @Test
    @DisplayName("사다리 높이가 정상적으로 생성된다.")
    void ladderHeightTest() {
        int ladderHeight = 1;
        assertDoesNotThrow(() -> new LadderHeight(ladderHeight));
    }
}